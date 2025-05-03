package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest { // 클래스에서 돌리면 내부에 있는 테스트를 전부다 돌릴 수 있다. 순서보장 안된다 메서드 별로 돌아간다.

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 테스트가 끝날때 마다 메서드 데이터를 클리어해주는 로직 / 즉, save가 실행되면 afterEach 한번 그후 다음메서드가 실행된다.
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member,result);
        assertThat(member).isEqualTo(result); // member가 result와 똑같다면 초록불 다르면 빨간불. / Assertions static 가능.
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result1 = repository.findByName("spring1").get();
        assertThat(result1).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member memberAll = new Member();
        memberAll.setName("spring1");
        repository.save(memberAll);

        Member memberAll2 = new Member();
        memberAll2.setName("spring2");
        repository.save(memberAll2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
