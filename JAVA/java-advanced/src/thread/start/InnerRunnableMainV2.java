package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV2 {

    public static void main(String[] args) {
        log("main() start");

        Runnable runnable = new Runnable() { // 익명 클래스 / 특정 메서드 안에서만 간단히 사용하고 싶다면 익명 클래스로
            @Override
            public void run() {
                log("run");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        log("main() end");
    }
}
