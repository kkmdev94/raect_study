package thread.control.yield;

import thread.start.HelloRunnable;

import static util.ThreadUtils.sleep;

public class YieldMain {

    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }

    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                // 1. empty
//                sleep(1); // 2. sleep
                Thread.yield(); // 3. yield // 자바의 스레드가 RUNNABLE 상태일 때, 스케줄링은 2개의 상태를 보유한다.
                // 실행 상태 : CPU에서 스레드가 실제로 실행중
                // 실행 대기 상태 : 스레드가 실행 준비는 되었지만 CPU가 바빠서 스케줄링 큐에서 대기중.
                // 자바는 이 두가지의 상태를 구분할 수 없다. 두개다 RUNNABLE로 표시되며 yield와 슬립의 차이는 yield는 RUNNABLE 상태를 유지하면서 CPU를 양보하는 것이다.
            }
        }
    }
}
