package jpql;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction(); // 트랜잭션 호출
        tx.begin(); // 트랜잭션 시작

        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

//            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class); // 타입 명시가 가능하면 상관 X
//            // 하지만 아래처럼 String과 int를 각각 조회해서 출력해야할 경우 타입이 명확하지 않기에 타입 쿼리가 아닌 쿼리를 사용해야 한다.
//            Query query3 = em.createQuery("select m.username,m.age from Member m");
//
//            /**
//             * 결과 조회 API - getResultList / getSingleResult
//             */
//            // 반환에 타입이 있다면 제네릭에 들어가기에 리스트 타입으로 반환이 가능하여 for문으로 출력이 가능하다.
//            List<Member> resultList = query.getResultList();
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//
//            //하나의 값만 뽑고 싶다면(where절로 조건을 걸었다면) -> getSingleResult로 출력 가능 / 단 singleResult는 결과가 정확히 단 하나이여야 한다. 결과가 없거나 둘 이상이면 무조건 Exception 발생함.
//            Member singleResult = query.getSingleResult();
//            System.out.println("singleResult = " + singleResult);

            /**
             * 파라미터 바인딩 -이름 기준 / 위치 기준( 왠만하면 사용X )
             */
            //
//            TypedQuery<Member> query = em.createQuery("select m from Member m where m.username = :username", Member.class);
//            query.setParameter("username", "member1");
//            Member result = query.getSingleResult();
//            System.out.println("result = " + result.getUsername());

            // 메소드 체인을 활용하도록 설계가 되어 있어서 메소드 체인 활용
            Member result = em.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", "member1")
                .getSingleResult();

            System.out.println("result = " + result.getUsername());

            tx.commit(); // 성공시 커밋

        } catch (Exception e) {
            tx.rollback(); // 실패시 롤백
            e.printStackTrace();
        } finally {
            em.clear();
        }

        emf.close();
    }
}
