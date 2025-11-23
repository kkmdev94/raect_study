package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

//    @NotEmpty
    private String name;

    @Embedded
    private Address address;

    @JsonIgnore // 주문정보가 빠지고 회원정보만 가지고 옴.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
