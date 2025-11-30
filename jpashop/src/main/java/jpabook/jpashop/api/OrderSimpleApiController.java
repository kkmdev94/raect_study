package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.repository.order.simplequery.SimpleOrderQueryDto;
import jpabook.jpashop.repository.order.simplequery.OrderSimpleQuerryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xToOne
 * Order
 * Order -> Member
 * Order -> Delivery
 * <p>
 * 여기서 학습하는 내용은 알고 가면 좋은것이고 결론은 엔티티를 노출시키지 않는 것이다.
 * LAZY를 EAGER 즉 즉시로딩으로 바꾸면 안된다. 어짜피 바꿔도 성능최적화가 되지 않기에 의미가 없고 다른 API에도 문제가 생긴다.
 * Lazy 강제 초기화에 대해서는 메모장 확인.
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderRepository orderRepository;
    private final OrderSimpleQuerryRepository orderSimpleQuerryRepository;

    // 엔티티를 직접 노출시키니 무한 루프에 걸린다.
    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName(); // Lazy 강제 초기화.
            order.getDelivery().getAddress(); // Lazy 강제 초기화. //강제 초기화에 대해서는 OSIV를 배우면 된다.
        }
        return all;
    }

    /**
     * 쿼리가 총 1 + N + N번 실행되는 문제
     *  - order 조회 1번(order 조회 결과 수가 N이 된다)
     *  - order -> member 지연로딩 조회 N 번
     *  - order -> delivery 지연로딩 조회 N 번
     *  ex) order의 결과가 4개면 최악의 경우 1 + 4 + 4 번 실행된다
     *      - 지연로딩은 영속성 컨텍스트에서 조회하므로, 이미 조회돈 경우 쿼리를 실행한다.
     *      - 즉시 로딩(EAGER)로 바꿔도 동일하게 쿼리가 최적화 되지는 않는다.
     */
    @GetMapping("/api/v2/simple-orders")
    public List<SimpleOrderDto> ordersV2() {
        //ORDER 2개 -> 즉 조회 했을때 Order가 2개가 조회가 되었다(예시내용을 참고로)
        // N + 1 문제 -> 1 + 회원 N + 배송 N
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());

        // 2개
        List<SimpleOrderDto> result = orders.stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(Collectors.toList());

        return result;
    }

    // 패치 조인 사용
    @GetMapping("/api/v3/simple-orders")
    public List<SimpleOrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithMemberDelivery();

        List<SimpleOrderDto> result = orders.stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(Collectors.toList());
        return result;
    }

    @GetMapping("/api/v4/simple-orders")
    public List<SimpleOrderQueryDto> ordersV4() {
        return orderSimpleQuerryRepository.findOrderDtos();
    }

    @Data
    public class SimpleOrderDto {
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;

        public SimpleOrderDto(Order order) {
            orderId = order.getId();
            name = order.getMember().getName(); // LAZY 초기화
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress();  // LAZY 초기화
        }
    }
}
