package hello.springtx.apply;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 초기화 코드 (ex: @PostConstruct) 와 @Transactional 을 함께 사용하면 트랜잭션이 적용되지 않는 예시를 보여준다.
 * 이유는 초기화 코드가 먼저 호출되고, 그 다음에 트랜잭션 AOP가 적용되기에 초기화 시점에 트랜잭션을 획득 할 수 없기 때문이다.
 *
 * 대안은 초기화보다 더 이후에 스프링이 완전히 컨테이너 다 만들고 AOP 다 만든 다음에 호출을 하게 하는것.
 * 그 방안으로 @EventListener(ApplicationReadyEvent.class)를 적용
 */

@SpringBootTest
public class InitTxTest {

    @Autowired Hello hello;

    @Test
    void go() {
        // 초기화 코드는 스프링이 초기화 시점에 호출한다.
//        hello.initV1(); // 내가 직접 호출하면 트랜잭션이 걸리고 True가 나온다.
    }

    @TestConfiguration
    static class InitTxTestConfig{
        @Bean
        Hello hello(){
            return new Hello();
        }
    }

    @Slf4j
    static class Hello {

        @PostConstruct // 초기화 코드
        @Transactional // 트랜잭션 코드
        public void initV1() {
            boolean isActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("Hello init @PostConstruct tx active = {}" , isActive);
        }

        @EventListener(ApplicationReadyEvent.class)
        @Transactional
        public void initV2() {
            boolean isActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("Hello init ApplicationReadyEvent tx active = {}" , isActive);
        }
    }
}
