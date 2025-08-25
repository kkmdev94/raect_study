package hello.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckedTest {

    /**
     * Exception을 상속받은 예외는 체크 예외가 된다
     */
    static class MyCheckedException extends Exception {
        public MyCheckedException(String message) {
            super(message);
        }
    }

    static class Service {

    }

    static class Repository {
        public void call() throws MyCheckedException { // 던진다 / 이 에러를 컴파일러가 체크해 준다. 이것을 선언하지 않으면 컴파일이 되지 않음.
            throw new MyCheckedException("ex");
        }
    }
}
