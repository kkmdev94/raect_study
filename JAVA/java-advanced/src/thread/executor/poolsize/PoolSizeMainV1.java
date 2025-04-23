package thread.executor.poolsize;

import thread.executor.ExecutorUtils;
import thread.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.*;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class PoolSizeMainV1 {

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);
        ExecutorService es = new ThreadPoolExecutor(2,4,3000, TimeUnit.MILLISECONDS, workQueue);
        printState(es);

        es.execute(new RunnableTask("task1"));
        printState(es, "task1");

        es.execute(new RunnableTask("task2"));
        printState(es, "task2");

        es.execute(new RunnableTask("task3"));
        printState(es, "task3");

        es.execute(new RunnableTask("task4"));
        printState(es, "task4");

        es.execute(new RunnableTask("task5")); // Queue 까지 꽉차면 그순간부터 스레드 맥시멈 값이 mxamumPoolSize 값까지 증가된다. / 초과 스레드는 긴급할 때만 끌어와서 사용.
        printState(es, "task5");

        es.execute(new RunnableTask("task6"));
        printState(es, "task6");

        try {
            es.execute(new RunnableTask("task7")); // corePoolSize도 다차고 queue도 꽉차고 맥시멈 값까지 다 증가를 했다면 그때 RejeectedExecutionException 발생
            printState(es, "task7");
        } catch (RejectedExecutionException e) {
            log("task7 실행 거절 예외 발생 : " + e);
        }

        sleep(3000);
        log(" == 작업 수행 완료 == ");
        printState(es);

        sleep(3000);
        log(" == meximumPoolSize 대기 시간 초과 == ");
        printState(es);

        es.close();
        log(" == shutdown 완료 == ");
        printState(es);
    }
}
