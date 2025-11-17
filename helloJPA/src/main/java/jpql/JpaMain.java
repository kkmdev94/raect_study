package jpql;

import jakarta.persistence.*;

import java.util.Collection;
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
**/
             /**
             * 결과 조회 API - getResultList / getSingleResult
             */
/**
//            // 반환에 타입이 있다면 제네릭에 들어가기에 리스트 타입으로 반환이 가능하여 for문으로 출력이 가능하다.
//            List<Member> resultList = query.getResultList();
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//
//            //하나의 값만 뽑고 싶다면(where절로 조건을 걸었다면) -> getSingleResult로 출력 가능 / 단 singleResult는 결과가 정확히 단 하나이여야 한다. 결과가 없거나 둘 이상이면 무조건 Exception 발생함.
//            Member singleResult = query.getSingleResult();
//            System.out.println("singleResult = " + singleResult);
**/
            /**
             * 파라미터 바인딩 -이름 기준 / 위치 기준( 왠만하면 사용X )
             */
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
 **/
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

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("관리자");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//
//            member.setTeam(team);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
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
//            String query = "select function('group_concat', m.username) from Member m";
//
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }
            /**
             * 경로 표현식 : . 을 찍어 객체 그래프를 탐색하는 것
             *  - select m.username -> 상태 필드
             *      from Member m
             *      join m.team t -> 단일 값 연관 필드
             *      join m.orders o -> 컬렉션 값 연관 필드
             *      where t.name = '팀A'
             * 상태 필드(state field):단순히 값을 저장하기 위한 필드 (ex: m.username)
             * 연관 필드(association field) : 연관관계를 위한 필드
             *   - 단일 값 연관 필드 : @ManyToOne, @OneToOne, 대상이 엔티티(ex:m.team)
             *   - 컬렉션 값 연관 필드 : @OneToMany, @ManyToMany, 대상이 컬렉션(ex:m.orders)
             * 명시적 조인 : join 키워드 직접 사용
             *  - select m from Member m join m.team t
             * 묵시적 조인 : 경로 표현식에 의해 묵시적으로 SQL 조인 발생 (내부 조인만 가능)
             *  - select m.team from Member m
             *  아래 예제에서 보이겠지만 단일 값, 컬렉션 값 등은 전부다 묵시적 조인이 들어가는데,
             *   !! 실무에서는 묵시적 조인은 그냥 다 쓰지 말고 명시적 조인만 쓰는게 좋다. !!
             */
            /**
            Team team = new Team();
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("관리자1");
            member1.setTeam(team);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            member2.setTeam(team);
            em.persist(member2);

            em.flush();
            em.clear();
            // JPQL 언어로 안바뀌고 문자열로 인식된다면 Inject Language에서 Hibernate QL로 변경하면된다.
//            String query = "select m.username From Member m";

            // 단일값 연관경로 : 묵시적 내부 조인(inner join 발생, 탐색 O / 이렇게 Member에서 team으로 묵시적 join을 한 뒤 team의 내부도 탐색이 가능하다. / 실제 운영에서는 튜닝이 어렵기에 웬만해선 사용 X
//            String query = "select m.team.name From Member m";
//
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

            // 컬렉션 값 연관 경로 : 묵시적 내부 조인 발생, 탐색 X / From 절에서 명시적 조인을 통해 별칭을 얻으면 별칭을 통해 탐색 가능
            String query = "select m.username From Team t join t.members m";


            List<Member> result = em.createQuery(query, Member.class)
                    .getResultList();

            System.out.println("result = " + result);
             **/

            //25.11.17
            /**
             * 페치 조인 (왠만한 N + 1 문제는 이걸로 다 해결한다.)
             *  - 회원을 조회하면서 연관된 팀도 함께 조회(SQL 한번에)
             *  ex) JPQL : select m from Memeber m join fetch m.team
             *      SQL : SELECT M.*, T.* FROM MEMBER M INNER JOIN TEAM T ON M.TEAM_ID=T.ID
             * LAZY로 지연로딩을 설정해도 페치 조인이 우선으로 처리된다.
             *
             * 컬렉션 페치 조인
             *   - 일대다 관계, 컬렉션 페치 조인
             *   ex) JPQL : select t from Team t join fetch t.members where t.name = '팀A'
             *       SQL : SELECT T.*, M.* FROM TEAM T INNER JOIN MEMBER M ON T.ID= M.TEAM_ID WHERE T.NAME = '팀A'
             *
             * 하이버네이트5에서는 데이터 뻥튀기가 있어서 중복된 결과값이 나오지만 하이버네이트6에서는 중복값을 없애준다.
             * 만약 구버전인 하이버네이트5에서 개발을 하게 된다면 DISTINCT 라는 명령어를 사용한다
             *   - JPQL의 DISTINCT는 2가지 기능을 제공한다.
             *      1. SQL에 DISTINCT를 추가
             *      2. 애플리케이션에서 엔티티 중복 제거
             *   - 사용법은
             *      String query = "select distinct t From Team t join fetch t.members";
             *
             * 다대일은 뻥튀기가 애초에 없어서 큰 상관 없다.
             *
             * 페치 조인과 일반 조인의 차이
             *   - 일반 조인 실행시 연관된 엔티티를 함께 조회하지 않음
             *      ex) JPQL : select t from Team t join t.members m where t.name = '팀A'
             *          SQL : SELECT T.* FROM TEAM T INNER JOIN MEMBER M ON T.ID = M.TEAM_ID WHERE T.NAME = '팀A'
             *   - JPQL은 결과를 반환할 때 연관관계 고려 X
             *   - 단지 SELECT 절에 지정한 엔티티만 조회할 뿐
             *   - 여기서는 팀 엔티티만 조회하고, 회원 엔티티는 조회 X
             *   - 페치 조인을 사용할 때만 연관된 엔티티도 함께 조회(즉시 로딩)
             *   - 페치 조인은 객체 그래프를 SQL 한번에 조회하는 개념.
             *
             * 페치 조인의 한계
             *   - 페치 조인 대상에는 별칭을 줄 수 없다.
             *     1. 하이버네이트는 가능, 가급적 사용 X
             *   - 둘 이상의 컬렉션은 페치 조인 할 수 없다.
             *   - 컬렉션을 페치 조인하면 페이징 API(setFirstResult, setMaxResults)를 사용할 수 없다.
             *     1. 일대일, 다대일 같은 단일 값 연고나 필드들은 페치 조인해도 페이징 가능
             *     2. 하이버네이트는 경고 로그를 남기고 메모리에서 페이징(매우 위험)
             *
             * 페치 조인 - 정리
             *   - 모든 것을 페치 조인으로 해결할 수 없다.
             *   - 페치 조인은 객체 그래프를 유지할 때 사용하면 효과적이다.(X.X.x 이런식으로)
             *   - 여러 테이블을 조인해서 엔티티가 가진 모양이 아닌 전혀 다른 결과를 내야 하면, 페치 조인보다는 일반 조인을 사용하고 필요한 데이터들만 조회해서 DTO로 반환하는 것이 효과적
             */

            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("member3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

//            String query = "select m From Member m";
//            String query = "select m From Member m join fetch m.team"; // fetch join 사용
//            String query = "select t From Team t join fetch t.members"; // 컬렉션 fetch join 사용
//            String query = "select t From Team t join t.members m"; // 일반 조인일때.
//            String query = "select t From Team t join fetch t.members m"; // 별칭 사용 X, 가능은 하지만 가급적 사용 X 데이터 누락 및 정합성 이슈가 있다.
//            String query = "select m From Member m join fetch m.team t"; // 굳이 페이징을 써야 한다면 일대다인 로직을 다대 일로 변경
            String query = "select t From Team t"; // 두번째는 Team Entity로 들어가서 @BatchSize(size=100) 부여.

            List<Team> result = em.createQuery(query, Team.class)
                    .setFirstResult(0)
                    .setMaxResults(2)
                    .getResultList();
            
            // fetch 조인 루프
//            for (Member member : result) {
//                System.out.println("member = " + member.getUsername() + "," + member.getTeam().getName()); // 페치 조인으로 인해 TEAM은 프록시가 아닌 영속성 컨텍스트에 올라가서 출력된다.
//                // 회원1, 팀A(SQL)
//                // 회원2, 팀A(1차캐시)
//                // 회원3, 팀B(SQL)
//
//                // 회원100명 -> N + 1 문제
//            }

            System.out.println("result.size() = " + result.size());
            
            // 컬렉션 fetch 조인 루프
            for (Team team : result) {
                System.out.println("team = " + team.getName() + " |members =" + team.getMembers().size());
                for (Member member : team.getMembers()) {
                    System.out.println("-> member = " + member);
                }
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
