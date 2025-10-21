package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

/**
 * @Column
 *  - name = 필드와 매핑할 테이블의 컬럼 이름
 *  - insertable / updatable = 등록, 변경 가능 여부 (기본값은 ture, false로 하면 절대 등록,변경 불가)
 *  - nullable(DDL) = null값 허용 여부 설정 / false로 하면 DDL 생성 시 not null 제약조건이 붙는다
 *  - unique(DDL) = @Table의 UniqueConstraints와 같지만 한 컬럼에 간단하게 유니크 제약 조건을 걸때 사용 / 잘 사용 X 이름이 반영할 수 없어서 Table을 쓰지 이거는 안쓴다.
 *  - columnDefinition = 데이터 베이스 컬럼 정보를 직접 부여 / ex) varchar(100) default 'EMPTY'
 *  - length(DDL) = 문자의 길이 제약 / String에만 사용
 *  - precision, scale(DDL) = BigDecimal 타입에서 사용(BigInteger도 사용가능) / precision은 소수점 포함 전체 자리수(19), scale은 소수의 자리수(2) 참고로 double,float 타입은 적용 x
 *     아주 큰 숫자나 정밀한 소수를 다루어야 할 때만 사용.
 */
@Entity
public class Member2 {

    @Id
    private Long id;

    @Column(name = "name")
    private String username;
    private Integer age;

    // 열거형을 사용하고 싶을 때 사용. / EnumType에서 기본값은 ORDINAL인데 ORDINAL은 사용을 하지 않는다. 그냥 절대 사용 X
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 날짜 타입(Date, Time, TimeStamp) / 자바에서는 날짜랑 시간이 다 있지만 데이터 베이스에는 날짜, 시간, 날짜&시간 이렇게 있기에 3가지를 준다.
    // 이거는 이제 옛날 ... 이젠 LocalDate를 사용한다..
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // DB에 varchar보다 큰 데이터를 넣고 싶으면 사용.
    @Lob
    private String description;

    // DB와 전혀 관계없이 메모리에서만 사용하겠다는 선언.
    @Transient
    private int temp;

    public Member2() {
    }
}
