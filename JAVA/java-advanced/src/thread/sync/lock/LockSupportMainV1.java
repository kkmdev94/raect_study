package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ParkTest(), "Thread - 1");
        t1.start();

        // 잠시 대기하여 THread-1이 park 상태에 빠질 시간을 준다.
        sleep(100);
        log("t1 state : " + t1.getState());

        log("main -> unpark(t1)");

        LockSupport.unpark(t1); // 1. unpark 사용
//        t1.interrupt(); // 2. interrupt() 사용
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state : " + Thread.currentThread().getState());
            log("인터럽트 상태 : " + Thread.interrupted());
        }
    }
}
