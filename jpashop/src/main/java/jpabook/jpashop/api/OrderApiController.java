package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderRepository orderRepository;

    @GetMapping("/api/v1/orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName();
            order.getDelivery().getAddress();
            List<OrderItem> orderItems = order.getOrderItems();
            orderItems.stream().forEach(o -> o.getItem().getName());
        }
        return all;
    }

    @GetMapping("/api/v2/orders")
    public List<OrderDto> ordersV2() {
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());

        for (Order order : orders) {
            System.out.println("order ref = " + order + " id= " + order.getId());
        }

        List<OrderDto> collect = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());
        return collect;
    }

    /**
     * 25.12.16 fetch Join
     */
    @GetMapping("/api/v3/orders")
    public List<OrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithItem();
        List<OrderDto> collect = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());
        return collect;
    }
    /**
     * 25.12.17 fetch Join 페이징 한계돌파
     * member와 delivery paging 작업까지 진행.
     * default_batch_fetch_size 글로벌 설정을 하고 쿼리를 확인해보면 in 쿼리를 통해 한방 쿼리로 다 가져와 버린다 즉 1,n,m 증가 공식이 되는게 아닌 묶어서 다 가져와 버린다.
     *
     */
    @GetMapping("/api/v3.1/orders")
    public List<OrderDto> ordersV3_page(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "100") int limit) {
        List<Order> orders = orderRepository.findAllWithMemberDelivery(offset, limit); // member랑 delivery를 한번에 패치조인하는 메서드

        List<OrderDto> collect = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());
        return collect;
    }

    /**
     * DTO로 반환해라고 했을때 엔티티가 노출되면 안된다.
     * 아래의 로직처럼 랩핑도 안된다. POSTMAN으로 돌려보면 OrderItems의 스펙이 즉, 데이터가 외부에 전부 노출된다는 것이다.
     * 엔티티에 대한 의존을 완전히 끊어야 한다.
     */
    @Getter
    static class OrderDto {
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;
//        private List<OrderItem> orderItems;
        private List<OrderItemDto> orderItems;

        public OrderDto(Order order) {
            orderId = order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress();
//            order.getOrderItems().stream().forEach(o -> o.getItem().getName()); -> OrderItem 조차도 다 DTO로 바꾸어서 넘겨야 한다.
//            orderItems = order.getOrderItems();
            orderItems = order.getOrderItems().stream()
                    .map(orderItem -> new OrderItemDto(orderItem))
                    .collect(Collectors.toList());
        }
    }

    /**
     * 이렇게 한번더 DTO로 랩핑해서 나가기 떄문에 깔끔하게 엔티티 노출 없이 정보를 넘길 수 있다.
     */
    @Getter
    static class OrderItemDto {

        private String itemName; // 클라이언트의 요구가 3개라고 가정했을때.
        private int orderPrice;
        private int count;

        public OrderItemDto(OrderItem orderItem) {
            itemName = orderItem.getItem().getName();
            orderPrice = orderItem.getOrderPrice();
            count = orderItem.getCount();
        }
    }
}
