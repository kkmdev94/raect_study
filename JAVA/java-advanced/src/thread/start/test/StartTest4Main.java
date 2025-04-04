package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {

        while (true) {
            Thread thread1 = new Thread(new AThread(),"Thread-A");
            Thread thread2 = new Thread(new BThread(),"Thread-B");
            thread1.start();
            thread2.start();
        }
    }

    static class AThread implements Runnable {
        @Override
        public void run() {
            log("A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class BThread implements Runnable {
        @Override
        public void run() {
            log("B");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
