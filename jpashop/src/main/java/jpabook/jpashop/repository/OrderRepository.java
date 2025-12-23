package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.order.simplequery.SimpleOrderQueryDto;
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
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " o.status = :status";
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

    public List<Order> findAllWithMemberDelivery() {
        // 패치 조인 = Lazy나 proxy를 다 무시하고 값을 직접 Query를 날려서 확인한다. 이때 무시된 proxy의 가짜 객체 값이 아닌 진짜 객체값이 들어가 있다.
        return em.createQuery("select o from Order o" +
                " join fetch o.member m" +
                " join fetch o.delivery d", Order.class)
                .getResultList();
    }

    // DTO 반환에서는 Entity나 Value Object만 가능 DTO는 반환 불가능 그래서 new Operation을 사용해야 함.
    public List<SimpleOrderQueryDto> findOrderDto() {
        return em.createQuery(
                "select new jpabook.jpashop.repository.SimpleOrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address)" +
                        "from Order o" +
                   " join o.member m" +
                   " join o.delivery d", SimpleOrderQueryDto.class)
            .getResultList();
    }
    // 1대다에서 데이터가 뻥튀기 되어 버린다. 예를 들어 order가 2개고 orderItems가 4개면 order가 items 갯수만큼 증가되서 나온다.
//    public List<Order> findAllWithItem() {
//        return em.createQuery(
//                "select o from Order o" +
//                " join fetch o.member m" +
//                " join fetch o.delivery d" +
//                " join fetch o.orderItems oi" +
//                " join fetch oi.item i", Order.class)
//                .getResultList();
//    }
    // 위의 로직처럼 뻥튀기를 막기위해 distinct를 넣어 사용한다. 데이터 베이스의 디스틴트는 정말 한줄이 완벽하게 똑같아야 중복이 제거 된다. 하지만 JPA는 Order가 같은 ID 값이면 그냥 중복을 제거해준다.
    // 단점 : 페이징이 불가능하다. 1대 다를 페치 조인 하는순간 페이징이 불가능해진다. 1대 다가 아닌 다른것들은 페이징을 해도 상관 없다.
    // 컬렉션 페치 조인은 1개만 사용할 수 있다. 컬렉션 둘 이상에 페치 조인을 사용하면 데이터가 부정합하게 조회 될 수 있다.
    public List<Order> findAllWithItem() {
        return em.createQuery(
                        "select distinct o from Order o" +
                                " join fetch o.member m" +
                                " join fetch o.delivery d" +
                                " join fetch o.orderItems oi" +
                                " join fetch oi.item i", Order.class)
                .getResultList();
    }

    /**
     * 25.12.23 투원관계에서도 default_batch_fetch_size 설정했다는 가정하에 패치 조인을 제외하고 쿼리문을 날려도 된다.
     * 다만, 이렇게 되면 네트워크를 많이 타야 하기 떄문에 투원 관계에서는 패치 조인을 미리 잡고 진행하는게 좋다.
     */
    public List<Order> findAllWithMemberDelivery(int offset, int limit) {
        return em.createQuery("select o from Order o" +
                        " join fetch o.member m" +
                        " join fetch o.delivery d", Order.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
