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
            /** 25.11.12
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

//            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class); // 타입 명시가 가능하면 상관 X
//            // 하지만 아래처럼 String과 int를 각각 조회해서 출력해야할 경우 타입이 명확하지 않기에 타입 쿼리가 아닌 쿼리를 사용해야 한다.
//            Query query3 = em.createQuery("select m.username,m.age from Member m");
/**
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
             /**
//            TypedQuery<Member> query = em.createQuery("select m from Member m where m.username = :username", Member.class);
//            query.setParameter("username", "member1");
//            Member result = query.getSingleResult();
//            System.out.println("result = " + result.getUsername());

            // 메소드 체인을 활용하도록 설계가 되어 있어서 메소드 체인 활용
            Member result = em.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", "member1")
                .getSingleResult();

            System.out.println("result = " + result.getUsername());
**/
            //25.11.13
            /**
             * 프로젝션
             *  - SELECT 절에 조회할 대상을 지정하는것
             *  - 프로젝션 대상 : 엔티티, 임베디드 타입, 스칼라 타입(숫자, 문자 등 기본 데이터 타입)
             *
             * 엔티티 프로젝션을 하면 대상이 셀렉트 절에 한 10개 20개 나오는데 걔들이 다 영속성 컨텍스트에서 다 관리된다.
             * 따라서 해당 내용들은 바꾸면 다 정상적으로 데이터에 반영이 된다.
             */
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            em.flush();
            em.clear();
            // 엔티티 프로젝션
//            List<Member> result = em.createQuery("select m from Member m", Member.class)
//                    .getResultList();
//
//            Member findMember = result.get(0);
//            findMember.setAge(20);
//
//            System.out.println("findMember.getAge() = " + findMember.getAge()); // test 결과 바뀌는게 확인되어 영속성 컨텍스트에서 관리됨을 확인함.

            // Table이 다르므로 Join 쿼리가 나간다. 하지만 쿼리 튜닝에서 복잡함이 생기고 예측이 어렵기에 Join은 다 직접 명시적으로 표시하는게 좋다.
//            List<Team> result = em.createQuery("select m.team from Member m", Team.class)
//                    .getResultList();

            // 임베디드 타입 프로젝션 / 임베디드 타입에서는 임베디드는 모두 어딘가에 속해 있기에 어디에 속해있는지에 대한 엔티티를 딱 정해줘야한다.
            em.createQuery("select o.address from Order o", Address.class)
                    .getResultList();

            // 스칼라 타입 프로젝션 / 막 가져오는 것을 뜻함. 스칼라 타입의 풀이는 메모에 상세.
//            List resultList = em.createQuery("select m.username, m.age from Member m")
//                    .getResultList();

//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;
//            System.out.println("result[0] = " + result[0]);
//            System.out.println("result[0] = " + result[1]);

            // 스칼라 타입의 확인 법중 하나. new 타입 / 마치 생성자를 호출하듯이.
            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
                    .getResultList();

            MemberDTO memberDTO = resultList.get(0);
            System.out.println("memberDTO = " + memberDTO.getUsername());
            System.out.println("memberDTO = " + memberDTO.getAge());

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
