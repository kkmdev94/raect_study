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
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member3 member3 = new Member3();
//            member3.setUsername("member1");
//            member3.setTeamId(team.getId()); // 연관관계 매핑으로 사용 X
//            member3.setTeam(team);
//            em.persist(member3);
//
//            em.flush();
//            em.clear();

            // 멤버에서 팀으로 <-> 팀에서 멤버로 왔다갔다 하는 이 상황이 양방향 연관관계
//            Member3 findMember = em.find(Member3.class, member3.getId()); // 멤버에서 조회
//            List<Member3> members = findMember.getTeam().getMembers(); // 역방향인 팀에서 조회
//
//            for (Member3 member : members) {
//                System.out.println("member.getUsername() = " + member.getUsername());
//            }

            // 25.10.27

//            Team team = new Team();
//            team.setName("TeamA");
//            team.getMembers().add(member3); //읽기 전용이라 들어가지 않는다.
//            em.persist(team);
//
//            Member3 member3 = new Member3();
//            member3.setUsername("member1");
//            member3.setTeam(team);
//            em.persist(member3);

            //객체 지향적으로 양쪽에 다 값을 걸어야 하며, 걸지 않으면 두가지의 문제가 생긴다. / 간단하게 생각하면 양방향 영속성을 할때는 양쪽에 값을 다 넣는게 편하다.
            // 선생님의 추천은 연관관계 편의 메소드를 생성하는 것이다. / Member3에서 확인. / 1에도 되고 다 에도 편하게 아무대나 편의메소드를 생성해도 되지만 둘다 하면 무한루프에 걸리니 조심하자.
            // 또한 toString(), lombok, JSON 생성 라이브러리 같은 경우도 무한루프에 걸릴 수 있다. / 단 JSON 생성 라이브러리의 답을 드리자면, 컨트롤러에서는 절대 엔티티를 반환하지 않으면 된다.
//            team.getMembers().add(member3);

            // 첫번째 문제는 flush와 clear의 유무, 플러쉬와 클리어를 하면 문제가 없지만 하지 않는다면 1차캐시에 있는 내용을 찾지 못하고 셀렉되지 않는다.
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId()); // 플러쉬와 클리어를 안하면 1차 캐시에 있음.
//            List<Member3> members = findTeam.getMembers();
//
//            for (Member3 m : members) {
//                System.out.println("m.getUsername() = " + m.getUsername());
//            }

            //25.10.28 OneToMany
//            Member3 member = new Member3();
//            member.setUsername("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//
//            team.getMembers().add(member);
//
//            em.persist(team);
//

            //25.10.31
            Movie movie = new Movie();
            movie.setActor("aaaa");
            movie.setDirector("abcd");
            movie.setName("13245324");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMove = em.find(Movie.class, movie.getId());
            System.out.println("findMove = " + findMove);

            tx.commit(); // 트랜잭션 커밋
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
