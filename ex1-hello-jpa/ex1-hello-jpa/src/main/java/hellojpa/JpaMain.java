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
//            //insert
//            Member member = new Member();
//
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);
//
//            //update
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//
//            findMember.setName("HelloJPA"); // 그 이후 persist는 안해도 된다 / JPA가 자동으로 update쿼리로 내보내줌.
//
//            //delete
//            em.remove(findMember);
//
//            //jpql 맛보기
//            List<Member> result = em.createQuery("Select m from Member as m", Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }
            // 비영속 (멤버 엔티티의 상태가 비영속 상태)
//            Member member = new Member();
//            member.setId(100L); // 1차 캐시에 저장
//            member.setName("HelloJPA");
//
//            // 여기서 부터 영속상태
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            Member findMember1 = em.find(Member.class, 100L);
//            Member findMember2 = em.find(Member.class, 100L);
//            System.out.println("findMember.getId() = " + findMember1.getId());
//            System.out.println("findMember.getName() = " + findMember1.getName());

            //new 영속
//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");
//
//            em.persist(member1);
//            em.persist(member2);

            // 변경 감지(Dirty Checking / setName을 통한 변경 후 persist는 사용하지 않는다.)
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZZZ");
//
//            if(member.getName().equals("ZZZZZZ")){
//                em.persist(member);
//            }
            //flush  commit 전에 DB에 바로 반영. 단, 1차 캐쉬는 그대로 유지된다.
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush();

            // 준영속 상태
//            Member member = em.find(Member.class, 150L); // 여기까지는 영속성 상태.
//            member.setName("AAAAA");
//
//            em.detach(member); // JPA에서 관리 안하는 준영속 상태.
//            em.clear(); // 엔티티 매니저 안에 있는 영속성 컨텍스트를 통째로 다 지워버림.
//
//            System.out.println("=========================");

//            Member2 member2 = new Member2();
//            member2.setUsername("ID_A");
//
//            em.persist(member2);

            //25.10.24 연관관계
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member3 member3 = new Member3();
            member3.setUsername("member1");
//            member3.setTeamId(team.getId()); // 연관관계 매핑으로 사용 X
            member3.setTeam(team);
            em.persist(member3);

            em.flush();
            em.clear();

            // 멤버에서 팀으로 <-> 팀에서 멤버로 왔다갔다 하는 이 상황이 양방향 연관관계
            Member3 findMember = em.find(Member3.class, member3.getId()); // 멤버에서 조회
            List<Member3> members = findMember.getTeam().getMembers(); // 역방향인 팀에서 조회

            for (Member3 member : members) {
                System.out.println("member.getUsername() = " + member.getUsername());
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
