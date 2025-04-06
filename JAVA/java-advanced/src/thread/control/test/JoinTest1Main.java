package thread.control.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinTest1Main {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        t1.start(); // 1-3 출력
        t1.join(); // t1이 끝날때 까지 대기

        t2.start(); // 1-3 출력
        t2.join(); // t2가 끝날떄까지 대기

        t3.start();
        t3.join();
        System.out.println("all Thread complate");
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                log(i);
                sleep(1000);
            }
        }
    }
}
