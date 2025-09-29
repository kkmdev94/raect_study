package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired EntityManager em;
    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception {
        //given
        Member member = createMember();

        Item book = createBook("시골 JPA", 10000, 10);

        int orderCount = 2;

        //when

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDER, getOrder.getStatus(), "상품 주문시 상태는 ORDER");
        assertEquals(1,getOrder.getOrderItems().size(),"주문한 상품 종류 수가 정확해야 한다.");
        assertEquals(10000*orderCount, getOrder.getTotalPrice(), "주문 가격은 가격 * 수량이다.");
        assertEquals(8, book.getStockQuantity(), "주문 수량만큼 재고가 줄어야 한다.");
    }

    @Test
    public void 상품주문_재고수량초과() throws Exception {
        //given
        Member member = createMember();
        Item book = createBook("시골 JPA", 10000, 10);

        int orderCount = 11;
        /**
         * 기존 코드는 이렇게 작성했찌만
         * // when
         * orderService.order(member.getId(), book.getId(), orderCount);
         *
         * // then
         * assertThrows(NotEnoughStockException.class, () -> {
         *     book.removeStock(11); // 재고보다 많은 수량 주문
         * });
         * 이렇게 작성하면 오류 발생...
         *
         * 이미 orderService.order(...) 안에서 book.removeStock(...) 이 실행되고 → NotEnoughStockException 이 던져졌습니다.
         * (스택트레이스 보면 OrderService → OrderItem.createOrderItem → Item.removeStock 에서 예외 발생)
         *
         * 그런데 assertThrows 는 람다 내부 실행 코드에서 예외가 나와야 잡힙니다.
         * 지금은 book.removeStock(11) 을 새로 호출하는데, 그 전에 orderService.order() 호출에서 이미 예외가 던져졌으니 테스트가 실패한 거예요.
         *
         * 즉, assertThrows 위치가 잘못된 거예요.
         *
         * 따라서 아래처럼 로직을 변경해서 작성해야 한다.
         */
        //when & then
        assertThrows(NotEnoughStockException.class, () -> {
            orderService.order(member.getId(), book.getId(), orderCount);
        });
    }

    @Test
    public void 주문취소() throws Exception {
        //given
        Member member = createMember();
        Item book = createBook("시골 JPA", 10000, 10);

        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);
        //when
        orderService.cancelOrder(orderId);

        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.CANCEL, getOrder.getStatus(), "주문 취소시 상태는 CANCLE이다.");
        assertEquals(10, book.getStockQuantity(), "주문 취소된 상품은 그만큼 재고가 증가해야 한다..");
    }

//    @Test
//    public void 상품주문_재고수량초과() throws Exception {
//        //given
//
//        //when
//
//        //then
//    }

    private Item createBook(String name, int price, int stockQuantity) {
        Item book = new Book();
        book.setName(name);
        book.setPrice( price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울","강가","123-123"));
        em.persist(member);
        return member;
    }
}