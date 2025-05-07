package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) { // 회원 가입
        // 같은 이름이 있는 중복 회원 X
//        Optional<Member> result = memberRepository.findByName(member.getName()); // Optional 을 생략 한 로직을 메서드로 따로 분리했다.
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        long start = System.currentTimeMillis();

        try{
            extracted(member);
            memberRepository.save(member);
            return member.getId();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("timeMs  = " + timeMs + "ms");
        }
    }

    private void extracted(Member member) { // findByName뒤로 쭉 로직이 나오는 이러한 로직은 메서드로 뽑아서 호출하는게 좋다.
        memberRepository.findByName(member.getName()) // Optional 생략
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        long start = System.currentTimeMillis();// 전체 회원 조회 / 서비스에서는 비즈니스적 네임을 사용하는것이 좋다.
        try {
            return memberRepository.findAll();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers  = " + timeMs + "ms");
        }
    }

    public Optional<Member> findOne(Long memberId) { // 멤버 아이디를 넘김.
        return memberRepository.findById(memberId);
    }
}
