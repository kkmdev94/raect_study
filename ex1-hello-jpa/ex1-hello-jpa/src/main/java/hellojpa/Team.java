package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 연관관계의 주인과 mappedBy
 * 객체와 테이블가네 연관관계를 맺는 차이를 이해해야 한다.
 * 객체 연관관계 = 2개
 *  - 회원 -> 팀 연관관계 1개(단방향)
 *  - 팀 -> 회원 연관관계 1개(단방향)
 *
 * 테이블 연관관계 = 1개
 *   - 회원 <-> 팀의 연관관계 1개(양방향)
 *
 * 객체의 양방향 관계는 사실 양방향 관계가 아니라 서로 다른 단방향관계 2개다
 * 테이블은 외래 키 하나로 두 테이블의 연관관계를 관리
 *   - MEMBER.TEAM_ID 외래 키 하나로 양방향 연관관계 가짐(양쪽으로 조인 가능)
 * 너무 길어서 memo에 작성
 */
@Entity
public class Team extends  BaseEntity{

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

//    다대일에서 양방향으로 변경할때 사용. 맵두바이는 필수적이다.
//    @OneToMany(mappedBy = "team")
//    private List<Member3> members = new ArrayList<>();
//
//    public void addMember(Member3 member) {
//        member.setTeam(this);
//        members.add(member);
//    }

    // 25.10.28 OneToMany
    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member3> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member3> getMembers() {
        return members;
    }

    public void setMembers(List<Member3> members) {
        this.members = members;
    }
}
