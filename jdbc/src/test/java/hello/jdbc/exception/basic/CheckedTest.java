package hello.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Exception을 상속받은 예외는 체크 예외가 된다.
 */

@Slf4j
public class CheckedTest {

    @Test
    void checked_catch() {
        Service service = new Service();
        service.callCatch();
    }

    @Test
    void checked_throw(){
        Service service = new Service();
        assertThatThrownBy(() -> service.callThrow())
                .isInstanceOf(MyCheckedException.class); // instance of가 service.callThrow의 로직이 실행되면 MyCheckedException의 Exception이 터져야된다는 의미이다.
    }

    /**
     * Exception을 상속받은 예외는 체크 예외가 된다
     */
    static class MyCheckedException extends Exception {
        public MyCheckedException(String message) {
            super(message);
        }
    }

    /**
     * Checked 예외는
     * 예외를 잡아서 처리하거나, 던지거나 둘중 하나를 필수로 선택해야 한다.
     */
    static class Service {
        Repository repository = new Repository();

        /**
         * 예외를 잡아서 처리하는 코드
         */
        public void callCatch() { // 여기서 처리하거나 던지거나, 즉 컴파일이 체크를 계속 해주기 때문에 체크 예외라고 한다.
            try {
                repository.call();
            } catch (MyCheckedException e) {
                // 예외 처리 로직 / "" 안에서 {}를 선언하면 e.getMessage()의 내용이 들어간다.
                log.info("예외 처리, message={}", e.getMessage(), e);
            }
        }

        /**
         * 체크 예외를 밖으로 던지는 코드
         * 체크 예외는 예외를 잡지 않고 밖으로 던지려면 throws 예외를 메서드에 필수로 선언해야 한다.
         * @throws MyCheckedException
         */
        public void callThrow() throws MyCheckedException {
            repository.call();
        }
    }

    static class Repository {
        public void call() throws MyCheckedException { // 던진다 / 이 에러를 컴파일러가 체크해 준다. 이것을 선언하지 않으면 컴파일이 되지 않음.
            throw new MyCheckedException("ex");
        }
    }
}
