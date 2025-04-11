package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(1000);

        task.runFlag = false;
        log("flag = " + task.runFlag + ", count = " + task.count + "in main");
    }

    static class MyTask implements Runnable {

        boolean runFlag = true;
        long count;

//        volatile boolean runFlag = true;
//        long count;

        @Override
        public void run() {
            while (runFlag) {
                count++;
                if (count % 100_000_000 == 0) {
                    log("falg = " + runFlag + ", count = " + count + " in while()");
                }
            }
            log("flag = " + runFlag + ", count = " + count + " 종료");
        }
    }
}
