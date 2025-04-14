package thread.sync.test;

import static util.MyLogger.log;

public class SyncTest3Main {

    public static void main(String[] args) throws InterruptedException {
        MyCounter myCounter = new MyCounter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                myCounter.counter();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        log("main end ");
    }

    static class MyCounter {
        Immutable immutable = new Immutable(0);
        int localValue = immutable.value;

        public void counter() {
            for (int i = 0; i < 10000; i++) {
                localValue = localValue + 1;
            }
            log("결과 : " + localValue);
        }
    }

    static class Immutable {
        private final int value;

        Immutable(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
