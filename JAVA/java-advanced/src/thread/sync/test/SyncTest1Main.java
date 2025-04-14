package thread.sync.test;

import static util.MyLogger.log;

public class SyncTest1Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        System.out.println("thread1 = " + counter.getCount());
        thread2.start();
        System.out.println("thread2 = " + counter.getCount());
        thread1.join();
        thread2.join();
        System.out.println("결과 = " + counter.getCount());
    }

    static class Counter {
        private int count = 0;

        public synchronized void increment() { // synchronized를 통해 하나의 스레드만 실행하게 되니 thread1이 만번 돌고 thread2도 만번 돌게 되는것이라 2만이 나옴.
            count = count + 1;
        }

        public int getCount() {
            return count;
        }
    }
}
