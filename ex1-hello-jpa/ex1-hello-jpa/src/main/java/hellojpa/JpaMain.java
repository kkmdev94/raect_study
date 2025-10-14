package hellojpa;

import jakarta.persistence.*;

import java.util.List;

/**
 * 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
 * 엔티티 매니저는 쓰레드간에 공유X(사용했으면 close를 통해 버려야 한다.)
 * JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
 */
public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction(); // 트랜잭션 호출
        tx.begin(); // 트랜잭션 시작
        try {
            //insert
//            Member member = new Member();
//
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);

            //update
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            findMember.setName("HelloJPA"); // 그 이후 persist는 안해도 된다 / JPA가 자동으로 update쿼리로 내보내줌.

            //delete
//            em.remove(findMember);

            //jpql 맛보기
            List<Member> result = em.createQuery("Select m from Member as m", Member.class)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }

            tx.commit(); // 트랜잭션 커밋
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
