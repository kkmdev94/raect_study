package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

//    MemberService memberService = new MemberService();

    @Test
    void 회원가입() {
//        //given -> 무언가가 주어졌는데
//        Member member = new Member();
//        member.setName("hello" +
//                "");
//        //when -> 이걸 실행 했을때
//        Long saveId = memberService.join(member);
//
//        //then -> 결과가 이게 나와야 돼
//        Member findMember = memberService.findOne(saveId).get();
//        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}