package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberService service = new MemberService();

    @Test
    public void save() {
        Member member = new Member();
        member.setId(1L);
        member.setName("spring");

        service.join(member);

        List<Member> members = service.findMembers();
        assertThat(members);
    }
}
