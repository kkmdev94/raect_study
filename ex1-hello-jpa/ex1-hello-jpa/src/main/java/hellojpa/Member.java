package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * JPA가 관리하는 객체.
 * 기본값은 클래스의 이름을 그대로 사용( ex)name = Member)
 * 다른 패키지에 같은 클래스 이름이 있는게 아니면 굳이 사용 X
 *
 * @ 엔티티와 매핑할 테이블 지정
 */

@Entity
//@Table( name = "MBR") // -> 테이블 이름을 변경 실행했을때 from에서 테이블 이름이 MBR로 나온다.
public class Member {

    @Id
    private Long id;

//    @Column(unique = true, length = 10) DDL 생성 기능 / 제약 조건을 추가하거나 유니크 제약조건 추가하던가.
    // DDL 생성 기능은 DDL을 자동 생성할 때만 사용되고 JPA의 실행 로직에는 영향을 주지 않는다.
    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
