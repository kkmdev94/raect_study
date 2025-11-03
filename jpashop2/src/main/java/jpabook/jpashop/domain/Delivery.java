package jpabook.jpashop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Delivery extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "delivery") // 양방향
    private Order order;

    private String city;
    private String street;
    private String zipcode;

    private DeliveryStatus status;

}
