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
/**
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
 **/
            //25.11.14
            /**
             * 페이징 API  -> JPA는 페이징을 다음 두 API로 추상화
             * setFirstResult(int startPosition) : 조회 시작 위치(0부터 시작)
             * setMaxResults(int maxResult) : 조회할 데이터 수
             */
            /**
//            for (int i = 0; i < 100; i++) {
//                Member member = new Member();
//                member.setUsername("member" + i);
//                member.setAge(i);
//                em.persist(member);
//            }
//
//
//            em.flush();
//            em.clear();
//
//            List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            System.out.println("result.size() = " + result.size());
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }
            // JOIN
            /**
             * 아래 로직을 실행해 보면 이상한 select 쿼리가 한번더 나가는데 해당 쿼리가
             * 1대다에서 조심해야 할것이 패치를 항상 레이지로 잡아야 하는 것이다.
             *
             * 내부 조인 : SELECT m FROM Member m [INNER] JOIN m.team t // INNER는 디폴트라 생략 가능
             * 외부 조인 : SELECT m FROM Member m LEFT [OUTER] JOIN m.team t
             * 세타 조인 : SELECT count(m) from Member m, Team t where m.username = t.name
             *
             * from절  서브 쿼리가 안된다.(JPQL에서)
             * select mm from (select m.age from Member m) as mm" <- 이런 프롬절에 들어가는 서브 쿼리가 안된다.
             */
            /**
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);

            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

//            String query = "select m from Member m inner join m.team t";

            // 조인 대상 필터링 = on
            // SELECT m, t FROM Member m LEFT JOIN m.team t on t.name = 'A'
//            String query = "select m from Member m left join m.team t on t.name = 'teamA'";

            // 연관관계 없는 엔티티 외부 조인
            // SELECT m, t FROM Member m LEFT JOIN Team t on m.username = t.name
            String query = "select m from Member m left join Team t on m.username = t.name";


            List<Member> result = em.createQuery(query, Member.class)
                    .getResultList();

**/
            //25.11.15
            /**
             * JPQL 타입 표현
             *  - 문자 : 'HELLO', 'She''s' = 싱글쿼테이션으로 표시
             *  - 숫자 : 10L(Long), 10D(Double), 10F(Float)
             *  - Boolean : true, false
             *  - ENUM : jpabook.MemberType.Admin( 패키지명이 들어가야 한다.)
             *  - 엔티티 타입 : TYPE(m) = Member (상속관계에서 사용)
             * 조건식 - CASE 식
             *   - 기본 CASE 식 : Select case when m.age <= 10 then '학생요금' when m.age >= 60 then '경로요금' else '일반요금' end from Member m
             *   - 단순 CASE 식 : Select case t.name when '팀A' then '인센티브110%' when '팀B' then '인센티브120%' else '인센티브105%' end from Team t
             *   - COALESCE : 하나씩 조회해서 null이 아니면 반환 / select coalesce(m.username, '이름 없는 회원') from Member m
             *   - NULLIF : 두 값이 같으면 null 반환, 다르면 첫번째 값 반환 / select NULLIF(m.username, '관리자') from Member m
             * JPQL 기본함수
             * 사용자 정의 함수 호출
             *  - 하이버네이트는 사용전 방언에 추가 필요 -> 하이버네이트6에서는 방언 추가가 필요가 없다.
             *  - 최신 방식 (Hibernate 6 이상): 현재는 FunctionContributor라는 인터페이스를 구현하고,
             *      이를 Java의 서비스 로더(ServiceLoader) 메커니즘을 통해 등록하는 방식을 사용합니다 -> Gemini 확인.
             */

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("관리자");
            member.setAge(10);
            member.setType(MemberType.ADMIN);

            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

//            String query = "select m.username, 'HELLO', TRUE From Member m " +
//                    "where m.type = jpql.MemberType.USER";
//            List<Object[]> result = em.createQuery(query)
//                    .getResultList();
//
//            for (Object[] objects : result) {
//                System.out.println("objects[0] = " + objects[0]);
//                System.out.println("objects[1] = " + objects[1]);
//                System.out.println("objects[2] = " + objects[2]);
//            }
            // 기본
//            String query = "select " +
//                    "case when m.age <= 10 then '학생요금'" +
//                    "when m.age >= 60 then '경로요금'" +
//                    "else '일반요금' end " +
//                    "from Member m";
            // COALESCE
//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m";

            //NULLIF
//            String query = "select NULLIF(m.username, '관리자') from Member m";

            //JPQL 기본함수
            //CONCAT (문자 A와 B를 더하는것) || <- 이것도 가능.
//            String query = "select concat('a', 'b') from Member m";
            //SubString 문자열 자르기
//            String query = "select substring(m.username, 2, 3) from Member m";
            //Trim 공백제거
            //Lower,UPPER 대소문자 변경
            //LENGTH 문자의 길이
//            // LOCATE 찾는 문자나 숫자가 몇번째에 있는지 확인(Integer Type으로 반환됨)
//            String query = "select locate('de','abcdefg') from Member m";
//            // ABS.SQRT,MOD 수학 펑션들
//            String query = "select substring(m.username, 2, 3) from Member m";
//            //SIZE, INDEX(JPA용도) size = 해당 컬렉션의 크기를 알려줌 / index는 거의 안씀
            String query = "select function('group_concat', m.username) from Member m";

            List<String> result = em.createQuery(query, String.class)
                    .getResultList();

            for (String s : result) {
                System.out.println("s = " + s);
            }

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
