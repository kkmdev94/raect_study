package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository_1 {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member_1 member1) {
        em.persist(member1);
        return member1.getId();
    }

    public Member_1 find(Long id) {
        return em.find(Member_1.class, id);
    }
}
