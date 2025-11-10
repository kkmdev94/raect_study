package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{
            // 비즈니스 로직
//
//            Order order = new Order();
////            order.addOrderItem(new OrderItem());
//            em.persist(order);
//
//            // 양방향 연관관계가 아니여도 앱개발에는 아무 문제가 없다.
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//
//            em.persist(orderItem);

            /**
            //25.11.03
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            em.persist(book);
             **/

            //25.11.10
            //Embedded table create

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
