package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThredStopMainV3 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(10);
        log("작업 중단 지시 thread..interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }
    // 인터럽트는 강제로 멈추는것이기 때문에 true면 계속 interrupt 상태가 유지되기 떄문에 입셉션이 계속 발생 할 수 있다. 그래서 Exception을 발생시키지 않기 위해
    // interrupt가 한번 발생하면 fasle 즉 이제는 인터럽트 상태가 아니다 라고 정상으로 돌려야 한다.

    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) { // 인터럽트 상태는 변경하지 않는다. 즉, TRUE에서 FALSE로 바꾸지 않는다.
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            try {
                log("자원 정리");
                Thread.sleep(1000);
                log("자원 종료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }
            log("작업 종료");
        }
    }
}
