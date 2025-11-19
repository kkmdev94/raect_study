package jpabook.jpashop.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다.") // gradle에 implementation 'org.springframework.boot:spring-boot-starter-validation' 추가함 / 일정버전은 추가 필요.
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
