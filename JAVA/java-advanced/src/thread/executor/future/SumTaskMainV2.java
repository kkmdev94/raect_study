package thread.executor.future;

import java.util.concurrent.*;

import static util.MyLogger.log;

public class SumTaskMainV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = es.submit(task1); // 블로킹 X
        Future<Integer> future2 = es.submit(task2); // 블로킹 X
        // Future라는 개념이 없다면 결과를 받을때 까지 아무것도 못하고 블로킹당하여 대기하여야 했다. 하지만 우선적으로 Future에 값을 받아 놓고 get을 통한 결과값을 호출한다면
        // 해당 get 메서드 전에 미리 다른작업을 진행할 수 있고 멀티스레드를 사용할 수 있게 되는 것이다. 그래서 Future를 우선적으로 받는것이다.

        Integer sum1 = future1.get(); // 여기서 블로킹
        Integer sum2 = future2.get(); // 여기서 블로킹
        // Integer sum1 = es.submit(task1) <- 이 코드가 없는 이유는 요청하자마자 블로킹이 걸려서 단일스레드처럼 이 로직이 끝날때까지 다른 스레드를 호출할 수 없기 떄문이다.

        log("task1.result = " + sum1);
        log("task2.result = " + sum2);

        int sumAll = sum1 + sum2;
        log("task1 + task2 = " + sumAll);
        log("end");
        es.close();
    }

    static class SumTask implements Callable<Integer> {
        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws InterruptedException {
            log("작업 시작");
            Thread.sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue ; i++) {
                sum += i;
            }
            log("작업 완료 result = " + sum);
            return sum;
        }
    }
}
