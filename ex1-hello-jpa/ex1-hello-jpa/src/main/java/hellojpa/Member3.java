package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member3 {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    // 객체지향스럽게 모델링하기
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

//    @ManyToOne // 일대다 양방향 상황에서 편법으로 하는 방법, 일 대 다는 그냥 사용을 안하는게 제일 좋다고 한다.
//    @JoinColumn(insertable = false, updatable = false)
//    private Team team;

    //25.10.30
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    //    @ManyToMany // ManyToMany 즉 다대다는 객체에서는 가능하지만 DB에서는 안된다. 즉, JPA에서는 구현이 불가능해서 중간 테이블을 하나 만들어야 한다. 그래서 실무에서 사용 X
//    @JoinTable(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();
    //엔티티로 승격시킨 객체를 참조하도록 변경
    @OneToMany(mappedBy = "member3")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
//        team.getMembers().add(this); // 양방향 연관관계에서 주인이 되는 쪽에 편의 메서드를 생성하는 방법. 여기서는 set이 존재하기에 해당 메서드에 자신을 넣는 로직을 추가하였다.
    }
}
