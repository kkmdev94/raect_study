package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    // 실무에서는 동시성을 생각해서 ConcurrentHashMap이나 id에서도 atomic long을 사용해야 하지만 예제라 그냥 한다.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // -> key값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() { // test에서 메서드 실행 후 데이터 클리어를 위한 로직.
        store.clear();
    }

}
