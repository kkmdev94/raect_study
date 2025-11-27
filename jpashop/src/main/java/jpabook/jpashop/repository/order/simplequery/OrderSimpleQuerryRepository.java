package jpabook.jpashop.repository.order.simplequery;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 선생님 같은 경우 이렇게 Query용 클래스를 생성해서 뽑아서 따로 분리하는걸 선호하신다고 함.
 */

@Repository
@RequiredArgsConstructor
public class OrderSimpleQuerryRepository {

    private final EntityManager em;

    // DTO 반환에서는 Entity나 Value Object만 가능 DTO는 반환 불가능 그래서 new Operation을 사용해야 함.
    public List<SimpleOrderQueryDto> findOrderDtos() {
        return em.createQuery(
                        "select new jpabook.jpashop.repository.order.simplequery.SimpleOrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address)" +
                        " from Order o" +
                        " join o.member m" +
                        " join o.delivery d", SimpleOrderQueryDto.class)
                .getResultList();
    }
}
