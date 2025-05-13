package hello.core.beanfind;

import hello.core.AppConfigSpring;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigSpring.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로만 조회") // 구현이 아닌 역할에 의존해야한다. 좋은코드는 아니지만 가끔씩 필요 할 때가 있기에 알아두면 좋다.
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService",MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() { // 실패를 확인하는 코드로 예외가 터져야 성공이다.
//        ac.getBean("XXXX", MemberService.class);
//        MemberService XXXXX = ac.getBean("XXXX", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, // junit의 Assertions를 사용해야 Throws 사용 가능.
                () -> ac.getBean("XXXX", MemberService.class));
    }
}
