package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
/**
            //insert
            Member member = new Member();

            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);

            //update
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            findMember.setName("HelloJPA"); // 그 이후 persist는 안해도 된다 / JPA가 자동으로 update쿼리로 내보내줌.

            //delete
            em.remove(findMember);

            //jpql 맛보기
            List<Member> result = em.createQuery("Select m from Member as m", Member.class)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }
             비영속 (멤버 엔티티의 상태가 비영속 상태)
            Member member = new Member();
            member.setId(100L); // 1차 캐시에 저장
            member.setName("HelloJPA");

            // 여기서 부터 영속상태
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");

            Member findMember1 = em.find(Member.class, 100L);
            Member findMember2 = em.find(Member.class, 100L);
            System.out.println("findMember.getId() = " + findMember1.getId());
            System.out.println("findMember.getName() = " + findMember1.getName());

            new 영속
            Member member1 = new Member(150L,"A");
            Member member2 = new Member(160L,"B");

            em.persist(member1);
            em.persist(member2);

             변경 감지(Dirty Checking / setName을 통한 변경 후 persist는 사용하지 않는다.)
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZZZ");

            if(member.getName().equals("ZZZZZZ")){
                em.persist(member);
            }
            flush  commit 전에 DB에 바로 반영. 단, 1차 캐쉬는 그대로 유지된다.
            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush();

             준영속 상태
            Member member = em.find(Member.class, 150L); // 여기까지는 영속성 상태.
            member.setName("AAAAA");

            em.detach(member); // JPA에서 관리 안하는 준영속 상태.
            em.clear(); // 엔티티 매니저 안에 있는 영속성 컨텍스트를 통째로 다 지워버림.

            System.out.println("=========================");

            Member2 member2 = new Member2();
            member2.setUsername("ID_A");

            em.persist(member2);
 **/

/**
            25.10.24 연관관계
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member3 member3 = new Member3();
            member3.setUsername("member1");
            member3.setTeamId(team.getId()); // 연관관계 매핑으로 사용 X
            member3.setTeam(team);
            em.persist(member3);

            em.flush();
            em.clear();

             멤버에서 팀으로 <-> 팀에서 멤버로 왔다갔다 하는 이 상황이 양방향 연관관계
            Member3 findMember = em.find(Member3.class, member3.getId()); // 멤버에서 조회
            List<Member3> members = findMember.getTeam().getMembers(); // 역방향인 팀에서 조회

            for (Member3 member : members) {
                System.out.println("member.getUsername() = " + member.getUsername());
            }
 **/

/**
            // 25.10.27

            Team team = new Team();
            team.setName("TeamA");
            team.getMembers().add(member3); //읽기 전용이라 들어가지 않는다.
            em.persist(team);

            Member3 member3 = new Member3();
            member3.setUsername("member1");
            member3.setTeam(team);
            em.persist(member3);

            객체 지향적으로 양쪽에 다 값을 걸어야 하며, 걸지 않으면 두가지의 문제가 생긴다. / 간단하게 생각하면 양방향 영속성을 할때는 양쪽에 값을 다 넣는게 편하다.
             선생님의 추천은 연관관계 편의 메소드를 생성하는 것이다. / Member3에서 확인. / 1에도 되고 다 에도 편하게 아무대나 편의메소드를 생성해도 되지만 둘다 하면 무한루프에 걸리니 조심하자.
             또한 toString(), lombok, JSON 생성 라이브러리 같은 경우도 무한루프에 걸릴 수 있다. / 단 JSON 생성 라이브러리의 답을 드리자면, 컨트롤러에서는 절대 엔티티를 반환하지 않으면 된다.
            team.getMembers().add(member3);

             첫번째 문제는 flush와 clear의 유무, 플러쉬와 클리어를 하면 문제가 없지만 하지 않는다면 1차캐시에 있는 내용을 찾지 못하고 셀렉되지 않는다.
            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId()); // 플러쉬와 클리어를 안하면 1차 캐시에 있음.
            List<Member3> members = findTeam.getMembers();

            for (Member3 m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }

            25.10.28 OneToMany
            Member3 member = new Member3();
            member.setUsername("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("teamA");

            team.getMembers().add(member);

            em.persist(team);
**/

/**
            //25.10.31
            Movie movie = new Movie();
            movie.setActor("aaaa");
            movie.setDirector("abcd");
            movie.setName("13245324");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

//            Movie findMove = em.find(Movie.class, movie.getId());
            Movie findMove = em.find(Movie.class, movie.getId()); // TABLE_PER_CLASS를 사용할 때 위험한것은 조회할때 객체 지향이다보니 Item 타입으로 조회할 수 도 있는데 조회할때
            //                                                        Union을 통해서 테이블을 전체 다 select 해서 비효율적으로 작동한다.
            System.out.println("findMove = " + findMove);

            Member3 member3 = new Member3();
            member3.setUsername("user1");
            member3.setCreatedBy("kim");
            member3.setCreatedDate(LocalDateTime.now());

            em.persist(member3);

            em.flush();
            em.clear();
**/

/**
            //25.11.04
            Member3 member3 = em.find(Member3.class, 1L);

            printMember(member3);

            printMemberAndTeam(member3);

            Proxy
            Member3 member3 = new Member3();
            member3.setUsername("hello");
            em.persist(member3);

            em.flush();
            em.clear();
            
            Member3 findMember = em.find(member3.getClass(), member3.getId());
            Member3 findMember = em.getReference(member3.getClass(), member3.getId());

            System.out.println("findMember.getClass() = " + findMember.getClass());
            System.out.println("findMember.username = " + findMember.getUsername());
            System.out.println("findMember.id = " + findMember.getId());


             ==이 아닌 instanceof를 사용해야 하는 이유
            Member3 member3 = new Member3();
            member3.setUsername("hello");
            em.persist(member3);

            Member3 member4 = new Member3();
            member4.setUsername("hello1");
            em.persist(member4);

            em.flush();
            em.clear();

            Member3 m1 = em.find(Member3.class, member3.getId());
//            Member3 m2 = em.find(Member3.class, member4.getId()); // True
            Member3 m2 = em.getReference(Member3.class, member4.getId()); // false

//            System.out.println(" m1 == m2 :  " + (m1.getClass() == m2.getClass())); // 타입 비교를 == 으로 하면안되는 이유.
            System.out.println(" m1 == m2 :  " + (m1 instanceof Member3));
            System.out.println(" m1 == m2 :  " + (m2 instanceof Member3));
            
            영속성 컨텍스트에 엔티티가 있으면 레퍼런스로 호출해도 같은 엔티티가 호출
            Member3 member3 = new Member3();
            member3.setUsername("hello");
            em.persist(member3);

            em.flush();
            em.clear();

            Member3 m1 = em.find(Member3.class, member3.getId());
            System.out.println("m1.getClass() = " + m1.getClass());

            Member3 reference = em.getReference(Member3.class, member3.getId());
            System.out.println("reference.getClass() = " + reference.getClass());

            영속성 컨텍스트에 엔티티가 있으면 레퍼런스로 호출해도 같은 엔티티가 호출(반대의 상황일때 / 프록시 -> 엔티티 이렇게 흘러도 true를 만들어야 하기에 프록시로 변경.)
            Member3 member3 = new Member3();
            member3.setUsername("hello");
            em.persist(member3);

            em.flush();
            em.clear();

            Member3 refMember = em.getReference(Member3.class, member3.getId());
            System.out.println("m1.getClass() = " + refMember.getClass());

            Member3 findMember = em.find(Member3.class, member3.getId());
            System.out.println("reference.getClass() = " + findMember.getClass());

            System.out.println("refMember == findMember : " + (refMember == findMember));

            //준영속 상태일 떄, 프록시 초기화 문제 발생
            Member3 member3 = new Member3();
            member3.setUsername("hello");
            em.persist(member3);

            em.flush();
            em.clear();

            Member3 refMember = em.getReference(Member3.class, member3.getId());
            System.out.println("refMember.getClass() = " + refMember.getClass());

            //영속성 컨텍스트를 실수로 종료
            em.detach(refMember);

            System.out.println("refMember.getUsername() = " + refMember.getUsername());

            // 프록시 인스턴스의 초기화 여부 확인
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
            // 프록시 클래스 확인 방법
            //Member3 refMember = em.getReference(Member3.class, member3.getId());
            // 프록시 강제 초기화
            Hibernate.initialize(refMember);
            //JPA 표준에 강제 초기화는 없다. / 강제 호출은 member.getName()
**/

/**
            //25.11.05 즉시로딩과 지연로딩
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            Member3 member3 = new Member3();
            member3.setUsername("hello");
            member3.setTeam(team);
            em.persist(member3);

            Member3 member4 = new Member3();
            member4.setUsername("hello2");
            member4.setTeam(team2);
            em.persist(member4);

            em.flush();
            em.clear();

            Member3 m = em.find(Member3.class, member3.getId());

            System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());

            System.out.println("================================");
            m.getTeam().getName(); // 초기화 / 지연로딩
            System.out.println("m.getTeam().getName() = " + m.getTeam().getName()); // 즉시로딩
            System.out.println("================================");

             JPQL에서 N + 1 문제를 발생시키는 예시 -> 즉시 로딩의 문제
            List<Member3> members = em.createQuery("select m from Member3 m join fetch m.team", Member3.class)
                    .getResultList();

            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
            em.persist(child1);  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true) 이때는 부모가 생명주기를 관리하기에 필요 없음.
            em.persist(child2);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
           findParent.getChildren().remove(0);
            em.remove(findParent); // 자식까지 삭제
 **/

/**
            // 25.11.06 @Embedded
            Member3 member = new Member3();
            member.setUsername("hello");
            member.setAddress(new Address("city", "street", "10"));
            member.setPeriod(new Period());

            em.persist(member);

            em.flush();
            em.clear();
**/


            // 25.11.06 값 타입과 불변객체
            /**
             * 임베디드 타입 같은 값 타입을 여러 엔티티에서 공유하면 위엄하다 사이드 이펙트가 발생한다.
             * 이럴경우에는 임베디드로 된 값 타입이 아닌 엔티티로 만들어서 새로운 객체가 되도록 해야한다.
             * 메모 확인.
             */
/**
            Address address = new Address("city", "street", "10000");

            Member4 member = new Member4();
            member.setUsername("member1");
            member.setAddress(address);
            em.persist(member);

            Address newAddress = new Address("newCity", address.getStreet(), address.getZipcode()); // 불변을 변경하려면 이렇게 새로 생성을 해야한다.

            /** 불변 객체 설명
            // 임베디드 타입에서는 해당 값을 그대로 쓰는게 아니라 new를 통해서 복사를 해서 사용해야 한다.
            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());

            Member4 member2 = new Member4();
            member2.setUsername("member1");
//            member2.setAddress(address);
            member2.setAddress(copyAddress); // 복사한 address를 사용, 컴파일 단계에서 검증 불가.
            em.persist(member2);

            member.getAddress().setCity("newCity"); // 사이드 이펙트 버그. / setter를 삭제해서 불변객체로 만들어서 변경이 안되게 한다.
             **/

            //25.11.07
            /**
             *  값 타입 컬렉션 사용
             *  값 타입 컬렉션도 라이프 사이클이 없어서 멤버에서 생명주기를 관리한다.
             *  별도의 persist나 update 할 필요가 없다.
             *  값 컬렉션들은 지연 로딩이다.
             */
            Member4 member = new Member4();
            member.setUsername("hello1");
            member.setAddress(new Address("city", "street", "10000"));

            member.getFavoriteFoods().add("pizza");
            member.getFavoriteFoods().add("burger");
            member.getFavoriteFoods().add("jokbal");

            // 값 컬렉션 사용 대신 -> Entity 승격
//            member.getAddressHistory().add(new Address("old1", "street", "10000"));
//            member.getAddressHistory().add(new Address("old2", "street", "10000"));

            member.getAddressEntity().add(new AddressEntity("old1", "street", "10000"));
            member.getAddressEntity().add(new AddressEntity("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("=============SELECT start===================");
            Member4 findMember = em.find(Member4.class, member.getId());

            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }

//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address.getCity() = " + address.getCity());
//            }
            System.out.println("=============SELECT END===================");
            System.out.println();
            System.out.println("=============UPDATE start===================");
            //homeCity -> newCity
//            findMember.getAddress().setCity("newCity"); // 이대로 바꾸면 사이드 이펙트 발생한다 / 항상 새로운 인스턴스를 생성해야한다.

            Address a = findMember.getAddress();
            findMember.setAddress(new Address("newCity",a.getStreet(),a.getZipcode()));

            // 컬렉션에 있는 pizza를 다른걸로
            findMember.getFavoriteFoods().remove("pizza");
            findMember.getFavoriteFoods().add("hansick"); // 삭제 후 새로 add 해야한다. 컬렉션도 값 타입이기 때문이다

            //주소 변경 / 제약 사항이 있는데 메모를 확인해야 한다.
            // 컬렉션은 기본으로 대상을 찾을 때는 ==이 아닌 equals를 사용한다. / 따라서 Equals랑 해시 코드가 제대로 구현이 되어 있어야 한다.
//            findMember.getAddressHistory().remove(new Address("old1", "street", "10000"));
//            findMember.getAddressHistory().add(new Address("new3", "street", "10000"));


            tx.commit(); // 트랜잭션 커밋
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }

//    private static void printMember(Member3 member3) {
//        System.out.println("member3.getUsername() = " + member3.getUsername());
//    }
//
//    private static void printMemberAndTeam(Member3 member3) {
//        String username = member3.getUsername();
//        System.out.println("username = " + username);
//
//        Team team = member3.getTeam();
//        System.out.println("team = " + team);
//    }
}
