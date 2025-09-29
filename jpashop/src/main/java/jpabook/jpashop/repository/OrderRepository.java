package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    /**
     * 동적 쿼리 지옥 시작. 기존 쿼리는 값이 있다는 가정
     * 만약에 이거를 값이 없으면 이런 문장(status)이 있으면 안 되겠죠
     * order search에 name 파라미터가 없으면 그 name 파라미터를 필터링 조건을 쓰지 말고 다 가져와
     * 그 다음에 상태 값도 선택되어 있지 않으면 여기 같은 경우에 이게 없으면 Null이겠죠
     * 이게 Null이면 상태 체크 하지 말고 그냥 주문이든 취소든 다 들고 와 라고 한다면 쿼리가 계속 바뀌어야 한다. 그걸 위한 동적 쿼리를 작성해야하는 과정이다.
     * 이것도 사용 안함. 문자열 조립하기 개빡셈.
     */
    public List<Order> findAllByString(OrderSearch orderSearch) {

//        return em.createQuery("select o from Order o join o.member m" + // 동적 쿼리가 아닐때
//                " where o.status = :status" +
//                " and m.name like : name", Order.class)
//                .setParameter("status", orderSearch.getOrderStatus())
//                .setParameter("name", orderSearch.getMemberName())
//                .setMaxResults(1000) // 최대 1000건
//                .getResultList();

        // 다음 방법(무식한 첫번째 방법)
        String jpql = "select o from Order o join o.member m";
        boolean isFirstCondition = true;
        // 주문 상태 검색
        if (orderSearch.getOrderStatus() != null) {
            if (isFirstCondition) {
                jpql += "where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += "o.status = :status";
        }

        //회원 이름 검색
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " m.name like :name";
        }

        TypedQuery<Order> query = em.createQuery(jpql, Order.class)
                .setMaxResults(1000); //최대 1000건

        if (orderSearch.getOrderStatus() != null) {
            query = query.setParameter("status", orderSearch.getOrderStatus());
        }
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            query = query.setParameter("name", orderSearch.getMemberName());
        }

        return query.getResultList();
    }

    /**
     * JPA Criteria
     * 이것도 사용 안함 / 유지 보수 난이도 헬
     * 그저 기준 스펙이라 그냥 보여주기식 이다.
     */
    public List<Order> findAllByCriteria(OrderSearch orderSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> o = cq.from(Order.class);

        Join<Object, Object> m = o.join("member", JoinType.INNER);

        List<Predicate> criteria = new ArrayList<>();

        // 주문 상태 검색
        if (orderSearch.getOrderStatus() != null) {
            Predicate status = cb.equal(o.get("status"), orderSearch.getOrderStatus());
            criteria.add(status);
        }
        //회원 이름 검색
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            Predicate name =
                    cb.like(m.<String>get("name"), "%" + orderSearch.getMemberName() + "%");
            criteria.add(name);
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000); //최대 1000건
        return query.getResultList();
    }
}
