package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

/**
 * Embeddable = 어딘가에 내장이 될 수 있다. / 내장 타입이다.
 */

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
