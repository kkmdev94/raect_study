package hellojpa;

import jakarta.persistence.*;

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
