package thread.executor.poolsize;

import thread.executor.ExecutorUtils;
import thread.executor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static thread.executor.ExecutorUtils.*;
import static util.MyLogger.log;

public class PoolSizeMainV2 {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
//        ExecutorService es = Executors.newFixedThreadPool(2,nThreads, 0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>()); // 위의 코드와 같은 의미다. / newFixedThreadPool에서 LinkedBlockingQueue는 무제한 queue를 받아준다.
        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 6; i++) {
            String taskName = "task " + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }
        es.close();
        log(" == shutdown 완료 == ");
    }
}
