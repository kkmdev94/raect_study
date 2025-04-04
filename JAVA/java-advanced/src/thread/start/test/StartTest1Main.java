package thread.start.test;

import static util.MyLogger.log;

public class StartTest1Main {

    public static void main(String[] args) {
        int count = 1;
        Thread thread = new Thread();
        for (int i = 0; i < 5; i++) {
            log("value : " + count);
            count++;
        }
        thread.start();
    }
}
