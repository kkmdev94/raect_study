package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.log;

public abstract class ExecutorUtils { // 추상

    public static void printState(ExecutorService executorService) {

//        executorService.getCorePoolSize // <- 없다.
//        ThreadPoolExecutor abc = (ThreadPoolExecutor) executorService; // <- 해당 캐스팅 과정을 편리하게 인스턴스 오브로 가능하게 한게 아래의 instanceof이다.

        if (executorService instanceof ThreadPoolExecutor poolExecutor) { // 구현체로 캐스팅 해야지만 사용이 가능하다. ExecutorService에서는 getCorePoolSize 같은 메서드가 없다.
            int pool = poolExecutor.getPoolSize(); // 풀에서 놀고있는 스레드 개수 / getCorePoolsize는 총 몇개의 풀을 가지고 있는지를 표시해주는거라 계속 pool에서 2가 나왔다
            int active = poolExecutor.getActiveCount(); // 실제 작업을 하고 있는 스레드 개수
            int queued = poolExecutor.getQueue().size(); // 생산자 소비자 구조에서 중간에 버퍼에 있던 queue가  바로 이 queue다. 즉, 해당메서드는 queue안에 작업이 몇개가 있는지 확인하는 것.
            long completedTask = poolExecutor.getCompletedTaskCount(); // 완료된 작업이 몇개인지 확인.
            log("[pool = " + pool + ", active = " + active + ", queuedTasks = " + queued + ", completedTask = " + completedTask + " ]");
        }else {
            log(executorService);
        }
    }

    // 추가
    public static void printState(ExecutorService executorService, String taskName) {

        if (executorService instanceof ThreadPoolExecutor poolExecutor) { // 구현체로 캐스팅 해야지만 사용이 가능하다. ExecutorService에서는 getCorePoolSize 같은 메서드가 없다.
            int pool = poolExecutor.getPoolSize(); // 풀에서 놀고있는 스레드 개수 / getCorePoolsize는 총 몇개의 풀을 가지고 있는지를 표시해주는거라 계속 pool에서 2가 나왔다
            int active = poolExecutor.getActiveCount(); // 실제 작업을 하고 있는 스레드 개수
            int queued = poolExecutor.getQueue().size(); // 생산자 소비자 구조에서 중간에 버퍼에 있던 queue가  바로 이 queue다. 즉, 해당메서드는 queue안에 작업이 몇개가 있는지 확인하는 것.
            long completedTask = poolExecutor.getCompletedTaskCount(); // 완료된 작업이 몇개인지 확인.
            log(taskName + "  -> [pool = " + pool + ", active = " + active + ", queuedTasks = " + queued + ", completedTask = " + completedTask + " ]");
        }else {
            log(taskName + " -> " + executorService);
        }
    }
}
