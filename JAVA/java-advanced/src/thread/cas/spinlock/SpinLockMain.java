package thread.cas.spinlock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SpinLockMain {

    public static void main(String[] args) {
//        SpinLockBad spinlock = new SpinLockBad();
        SpinLock spinlock = new SpinLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                spinlock.lock();
                try {
                    // critical section
                    log("비즈니스 로직 실행");
                    sleep(1); // 오래걸리는 로직에서 스핀 락 사용X
                } finally {
                    spinlock.unlock();
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
