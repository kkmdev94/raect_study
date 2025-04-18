package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;

public class BoundedQueueV6_4 implements BoundedQueue{

    private BlockingQueue<String> queue;

    public BoundedQueueV6_4(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        // 즉시 반환이지만 true / false가 아닌 Excetion을 터트리면서 예외 발생
        queue.add(data); // java.lang.IllegalStateException : Queue full
    }

    @Override
    public String take() {
        // 즉시 반환이지만 true / false가 아닌 Excetion을 터트리면서 예외 발생
        return queue.remove(); // java.util.NoSuchElementExcetion : No Data
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
