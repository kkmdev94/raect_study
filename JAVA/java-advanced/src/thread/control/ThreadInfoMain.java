package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId = " + mainThread.threadId());
        log("mainThread.getName = " + mainThread.getName());
        log("mainThread.getPriority = " + mainThread.getPriority());
        log("mainThread.getThreadGroup = " + mainThread.getThreadGroup());
        log("mainThread.getState = " + mainThread.getState());

        // myThread
        System.out.println();
        Thread myThread = new Thread(new HelloRunnable(),"myThread");
        log("myThread = " + myThread);
        log("myThread.threadId = " + myThread.threadId()); // 스레드의 고유 식별자를 반환, 이 ID는 JVM 내에서 각 스레드에 대해 유일하다. 자동 할당되며 직접 지정은 할 수 없다.
        log("myThread.getName = " + myThread.getName()); // 스레드의 이름을 반환하는 메서드 / 스레드 ID는 중복되지 않지만 스레드 이름은 중복 될 수 있다.
        log("myThread.getPriority = " + myThread.getPriority()); // 스레드의 우선순위를 반환하는 메서드 / 1(가장낮음) 부터 10(가장높음) 까지 설정. 기본값은 5
        // setPriority() 메서드를 이용해 변경 가능하다. 다만, 실제 실행 순서는 JVM 구현과 운영체제에 따라 달라질 수 있다.
        log("myThread.getThreadGroup = " + myThread.getThreadGroup()); //
        log("myThread.getState = " + myThread.getState());
    }
}
