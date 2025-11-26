package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @JsonIgnore // 양방에서 연관관계가 있을 경우 둘중 하나를 해줘야 한다. / 주문정보가 빠지고 회원정보만 가지고 옴. / 25.11.26
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // ORDINAL 사용 금지. STRING은 중간에 추가 되거나 순서가 밀려도 오류가 발생 하지 않기에 STRING을 사용/
    private DeliveryStatus Status; // READY, COMP
}
