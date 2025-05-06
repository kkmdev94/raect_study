package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{ // JPA를 사용할때는 항상 트랜젝션이 있어야 한다 그래서 회원가입이 실행되는 서비스에 트랜젝션을 추가했다.
    
    private final EntityManager em; // jpa에서 entitymanager를 통해 관리.

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); // insert 쿼리 만들어서 다 관리 및 넣어준다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) { // pk 기반이 아닌 애들은 JPQL을 작성해 주어야 한다.
        List<Member> result =  em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
    // jpql 이라는 쿼리 언어를 사용하는데, 객체를 대상으로 쿼리를 날린다.
    // 정확히는 엔티티를 대상으로 쿼리를 날리는것인데, 위에서 보면 select에서 * 이나 member.id 같은게 아닌 멤버 엔티티 자체를 셀렉트 하는 것이다.
}
