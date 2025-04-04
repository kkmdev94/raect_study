package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV4 {

    public static void main(String[] args) {
        log("main() start");

        Thread thread = new Thread(() -> log("run"));  // 아직 배우지 않은 람다로도 가능하다. 일단 이런것이 있구나 라고만 알자.
        thread.start();

        log("main() end");
    }
}
