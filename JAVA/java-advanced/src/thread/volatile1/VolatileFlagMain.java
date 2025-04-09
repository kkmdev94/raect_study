package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");
    }
    // 메모리 가시성(memory visibility) : 멀티스레드 환경에서 한 스레드가 변경한 값이 다른 스레드에서 언제 보이는지에 대한 문제
    // 이 예제에서는 runFlag를 false 로 바꿔도 while문이 종료가 되지 않고 work스레드가 계속 돌고있다. 이것은 캐시메모리를 이용하기 때문에 main에서 false로 바꿔도 캐시메모리에서 바뀌기에
    // 메인메모리에 언제 바뀔지도 모르고, 메인메모리가 바뀌었다 한들 다시 work스레드의 캐시메모리에 언제 가져갈지도 모른다.
    // 이러한 문제는 컨텍스트 스위칭이 될 때 스레드가 잠깐 쉬면서 컨텍스트 스위칭이 되는데 이것또한 무조건 갱신을 보장하는 것은 아니다.
    // 이 문제를 해결하기 위한 메서드는 다음 장에서.

    static class MyTask implements Runnable {
        boolean runFlag = true;
//        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                //runFlag가 false로 변하면 탈출
            }
            log("task 종료");
        }
    }
}
