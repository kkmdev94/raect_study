package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //static 사용
    private static long sequence = 0L; //static 사용

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    //    Optional과 람다, 스트림에 익숙치 않을 때 사용하는 로직

//    public Member findByLoginId(String loginId) { // 람다와 스트림 익숙치 않을때 쓰는 로직
//        List<Member> all = findAll(); // findAll 데이터를 리스트에 담아서
//        for (Member m : all) { // 루프를 돌린다.
//            if (m.getLoginId().equals(loginId)){ // m에서 getLoginId가 equals를 통해 넘어온 파라미터 값인 loginId와 같은가. 이때 같으면 m을 반환
//                return m;
//            }
//        }
//        return null;
//    } //

//    public Optional<Member> findByLoginId(String loginId) {
//        List<Member> all = findAll();
//        for (Member m : all) {
//            if (m.getLoginId().equals(loginId)){
//                return Optional.of(m);
//            }
//        }
//        return Optional.empty();
//    }

    public Optional<Member> findByLoginId(String loginId) { // 람다 스트림 사용 위에는 미사용
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // 밸류만 뽑아서 반환.
    }

    public void clearStore() {
        store.clear();
    }

}
