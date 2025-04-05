package thread.control;

import static util.ThreadUtils.sleep;

public class CheckedExceptionMain {

    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {

        @Override
        public void run() /*throws Exception*/{ // 자바 문법상의 오류
            // 그 이유는 부모 메서드가 체크 예외를 던지지 않는 경우, 재정의된 자식 메서드도 체크 예외를 던질 수 없다.
            // 자식 메서드는 부모 메서드가 던질 수 있는 체크 예외의 하위 타입만 던질 수 있다.
            // Runnable에서는 아무것도 예외처리를 하지 않기에 아무것도 할 수 없는 것이다.
//           throw new Exception(); // 주석 풀면 예외 발생
            sleep(1000); // 만들어낸 sleep
        }
    }
}
