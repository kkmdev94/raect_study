package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * xToOne
 * Order
 * Order -> Member
 * Order -> Delivery
 *
 * 여기서 학습하는 내용은 알고 가면 좋은것이고 결론은 엔티티를 노출시키지 않는 것이다.
 * LAZY를 EAGER 즉 즉시로딩으로 바꾸면 안된다. 어짜피 바꿔도 성능최적화가 되지 않기에 의미가 없고 다른 API에도 문제가 생긴다.
 * Lazy 강제 초기화에 대해서는 메모장 확인.
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderRepository orderRepository;

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
}
