package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

/**
 * 예외 누수 문제 해결
 * SQLException 제거
 *
 * MemberRepository 인터페이스 의존
 */
@Slf4j
public class MemberServiceV5 {

    private final MemberRepository memberRepository;

    public MemberServiceV5(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    @Transactional // 이 메서드를 시작할때 트랜젝션을 걸겟다 라는 애노테이션.
    public void accountTransfer(String fromId, String toId, int money)  {
        bizLogic(toId, money, fromId);
    }

    private void bizLogic(String toId, int money, String fromId) {
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);

        memberRepository.update(fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepository.update(toId, toMember.getMoney() + money);
    }

    private static void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")){
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}
