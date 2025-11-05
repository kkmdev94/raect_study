package jpabook.jpashop.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
public class Delivery extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY) // 양방향
    private Order order;

    private String city;
    private String street;
    private String zipcode;

    private DeliveryStatus status;

}
