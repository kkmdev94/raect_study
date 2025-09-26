package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @Rollback(false)
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member,memberRepository.findOne(savedId));
    }

    /**
     * 강의에서는 Junit4 버전이라 (expected = IllegalStateException.class) 이걸 사용했지만
     * Junit5 에서는 assertThrows를 사용한다.
     * assertThrows(IllegalStateException.class, () -> {
*              memberService.join(member2); //여기서 예외가 발생해야 테스트 성공!
 *          });
     */
    @Test
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
//        memberService.join(member2); //예외가 발생해야 한다.
//        try {
//            memberService.join(member2); //예외가 발생해야 한다.
//        } catch (IllegalStateException e) {
//            return;
//        }

        //then
        fail("예외가 발생해야 한다.");
        assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2); //여기서 예외가 발생해야 테스트 성공!
        });
    }
}