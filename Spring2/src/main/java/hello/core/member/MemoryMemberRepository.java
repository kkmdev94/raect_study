package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component  // 스프링 빈 등록을 위한 Component 추가. / 기본값으로 앞의 대문자가 소문자로 바꾸고 돌림. 즉, MemoryMemberRepository -> memoryMemberRepository 이렇게 된다.
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
