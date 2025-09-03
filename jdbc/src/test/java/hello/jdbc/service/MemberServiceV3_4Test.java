package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;
import java.sql.SQLException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 트랜잭션 - DataSource, transactionManager 자동 등록 (스프링 부트)
 *
 * [핵심 원리]
 * 이전 테스트(MemberServiceV3_3Test)와 달리 DataSource와 PlatformTransactionManager를 직접 빈으로 등록하지 않았다.
 * @SpringBootTest 어노테이션이 있으면, 스프링 부트는 테스트 시점에 application.properties와
 * 클래스패스의 라이브러리(H2 등)를 확인하여 데이터소스와 트랜잭션 매니저를 자동으로 스프링 빈으로 등록해준다.
 *
 * [중요]
 * 스프링 부트의 자동 설정은 테스트를 위해 매번 새로운 내장 메모리 DB(Embedded DB)를 생성한다.
 * 따라서 DB는 항상 비어있는 깨끗한 상태로 시작되며, 테이블도 존재하지 않는다.
 * 이 문제를 해결하기 위해 `src/test/resources/schema.sql` 파일을 추가해야 한다.
 * 스프링 부트는 이 파일을 발견하면 테스트 실행 전에 자동으로 실행하여 테이블을 생성해준다.
 */
@Slf4j
@SpringBootTest // Spring을 이용하여 테스트를 진행하고
class MemberServiceV3_4Test {

    public static final String MEMBER_A = "memberA";
    public static final String MEMBER_B = "memberB";
    public static final String MEMBER_EX = "ex";

    @Autowired // Autowired를 통해 의존관계를 주입해 준다.
    private MemberServiceV3_3 memberService;
    @Autowired
    private MemberRepositoryV3 memberRepository;

    /**
     * @TestConfiguration: 테스트 코드 내부에만 적용되는 별도의 설정을 추가할 때 사용한다.
     * 여기서는 DataSource와 TransactionManager는 스프링 부트의 자동 설정을 사용하고,
     * 우리가 직접 만든 MemberRepositoryV3와 MemberServiceV3_3만 빈으로 등록한다.
     */
    @TestConfiguration
    static class TestConfig {

        // 스프링 부트가 자동으로 생성해준 DataSource를 생성자를 통해 주입받는다.
        private final DataSource dataSource;

        @Autowired
        TestConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Bean
        MemberRepositoryV3 memberRepositoryV3() {
            return new MemberRepositoryV3(dataSource);
        }
        @Bean
        MemberServiceV3_3 memberServiceV3_3() {
            return new MemberServiceV3_3(memberRepositoryV3());
        }
    }

    /**
     * @AfterEach: 각 테스트가 끝난 후 항상 실행되어 다음 테스트에 영향을 주지 않도록 데이터를 정리한다.
     * 만약 이 코드가 없다면, 테스트가 실행 순서에 따라 성공하거나 실패하는 '테스트 격리' 문제가 발생한다.
     *
     * [오류 분석]
     * 만약 `schema.sql` 파일이 없다면, AopCheck() 테스트 실행 후 이 메서드가 호출될 때
     * `Table "MEMBER" not found` 오류가 발생한다.
     * AopCheck() 테스트는 DB에 데이터를 저장하지 않으므로 테이블이 생성되지 않은 상태에서
     * `delete()` SQL을 실행하려고 하기 때문이다.
     * 따라서 `schema.sql`로 테이블을 미리 생성해두는 것이 필수적이다.
     */
    @AfterEach
    void after() throws SQLException { // 로직 실행 후 실행.
        memberRepository.delete(MEMBER_A);
        memberRepository.delete(MEMBER_B);
        memberRepository.delete(MEMBER_EX);
    }

    @Test
    void AopCheck() {
        // MemberServiceV3_3은 @Transactional 어노테이션이 있으므로 AOP 프록시가 적용된다.
        log.info("memberService class={}", memberService.getClass());
        log.info("memberRepository class={}", memberRepository.getClass());
        assertThat(AopUtils.isAopProxy(memberService)).isTrue();
        assertThat(AopUtils.isAopProxy(memberRepository)).isFalse();
    }

    @Test
    @DisplayName("정상 이체")
    void accountTransfer() throws SQLException {
        //given
        Member memberA = new Member(MEMBER_A, 10000);
        Member memberB = new Member(MEMBER_B, 10000);
        memberRepository.save(memberA);
        memberRepository.save(memberB);

        //when
        log.info("START TX");
        memberService.accountTransfer(memberA.getMemberId(), memberB.getMemberId(), 2000);
        log.info("END TX");

        //then
        Member findMemberA = memberRepository.findById(memberA.getMemberId());
        Member findMemberB = memberRepository.findById(memberB.getMemberId());

        assertThat(findMemberA.getMoney()).isEqualTo(8000);
        assertThat(findMemberB.getMoney()).isEqualTo(12000);
    }

    @Test
    @DisplayName("이체중 예외 발생")
    void accountTransferEx() throws SQLException {
        //given
        Member memberA = new Member(MEMBER_A, 10000);
        Member memberEx = new Member(MEMBER_EX, 10000);
        memberRepository.save(memberA);
        memberRepository.save(memberEx);

        //when
        // MemberService의 @Transactional에 의해 계좌이체 중 예외가 발생하면 트랜잭션이 롤백된다.
        assertThatThrownBy(() ->memberService.accountTransfer(memberA.getMemberId(), memberEx.getMemberId(), 2000))
                .isInstanceOf(IllegalStateException.class);


        //then
        Member findMemberA = memberRepository.findById(memberA.getMemberId());
        Member findMemberB = memberRepository.findById(memberEx.getMemberId());

        // 롤백되었으므로 두 회원의 돈은 원래 상태로 돌아와야 한다.
        assertThat(findMemberA.getMoney()).isEqualTo(10000);
        assertThat(findMemberB.getMoney()).isEqualTo(10000);
    }
}