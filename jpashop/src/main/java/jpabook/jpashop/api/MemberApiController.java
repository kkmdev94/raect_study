package jpabook.jpashop.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    /**
     * Entity를 절대로 파라미터로 받지 말고 DTO를 만들어 별도의 파라미터를 받도록 해야 한다.
     * 무조건 필수적으로! 큰 장애가 발생할 수 있으며, 여러개의 방법으로 갈릴 수 있는 상황에서 하나의 엔티티로는 감당이 안된다.
     * 또한 Entity를 API를 사용시 외부에 노출되게 하면 안되기에 더욱 더 DTO가 필요하다.
     *
     * v1의 장점은 v2처럼 클래스를 안만들어도 된다 뿐인데 어짜피 Entity를 직접적으로 받기에 그냥 장점이 없다고 보면 된다.
     *
     * API는 들어오는것과 나가는것은 절대 Entity를 사용하지 않는다. DTO 사용할것!
     */
    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        Long id = memberService.join(member);
//        String city = member.getAddress().getCity();
//        String street = member.getAddress().getStreet();
//        String zipcode = member.getAddress().getZipcode();
//        return new CreateMemberResponse(id,city,street,zipcode);
        return new CreateMemberResponse(id);
    }

    //25.11.21 DTO 생성
    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {

        Member member = new Member();
        member.setName(request.getName());

        Long id = memberService.join(member);

        return new CreateMemberResponse(id);
    }

    @Data
    static class CreateMemberRequest {
        @NotEmpty
        private String name;
    }

    @Data
    static class CreateMemberResponse {
        private Long id;
//        private String city;
//        private String street;
//        private String zipcode;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }

//        public CreateMemberResponse(Long id, String city, String street, String zipcode) {
//            this.id = id;
//            this.city = city;
//            this.street = street;
//            this.zipcode = zipcode;
//        }
    }
}
