package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Rollback(false)
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo("memberA");

        /**
         * 잠깐만요 자 이거는 true 가 되어야 돼요
         * 왜냐하면 지금 같은 트랜잭션 안에서 이거를 저장을 하고 조회하면 영속성 컨텍스트가 똑같겠죠
         * 같은 영속성 컨텍스트 안에서는 id 값이 같으면 여러분 이제 같은 엔티티로 식별하는 거죠 그래서 그렇습니다.
         * 영속성 컨텍스트에서 식별자가 같으면 같은 엔티티로 인식한다고 보시면 되고 1차 캐시라고
         * 불리는 거기서 이미 영속성 컨텍스트에 엔티티가 관리되고 있는 똑같은 게 있기 때문에 그냥 기존에 관리하던 게 나와버린 거죠.
         * 그래서 여기 잘 보시면 아예 셀렉트 쿼리조차 안 나간 거예요. 인서트 쿼리만 나가고. 어? 나 영속성 컨텍스트에 있네 하고 그냥 1차 캐시에 있는 데서 그냥 쭉 꺼내와버린 거죠.
         */
        assertThat(findMember).isEqualTo(member);
        System.out.println("findMember == member : " + (findMember == member));
    }
}