package jpabook.jpashop.api;

import jakarta.validation.Valid;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        Long id = memberService.join(member);
        String city = member.getAddress().getCity();
        String street = member.getAddress().getStreet();
        String zipcode = member.getAddress().getZipcode();
        return new CreateMemberResponse(id,city,street,zipcode);
    }

    @Data
    static class CreateMemberResponse {
        private Long id;
        private String city;
        private String street;
        private String zipcode;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }

        public CreateMemberResponse(Long id, String city, String street, String zipcode) {
            this.id = id;
            this.city = city;
            this.street = street;
            this.zipcode = zipcode;
        }
    }
}
