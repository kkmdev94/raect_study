package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import static util.MyLogger.log;

public class BoundedQueueV1 implements BoundedQueue{ // 한정된 버퍼 역할을 하는 가장 단순한 구현체, 버전에 따라 업그레이드 예정

    private final Queue<String> queue = new ArrayDeque<>(); // 데이터를 중간에 보관하는 버퍼
    private final int max; // 한정된 버퍼이므로, 버퍼의 최대 크기를 지정

    public BoundedQueueV1(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) { // 큐에 데이터를 저장, 큐가 가득차면 저장 할 수 없으므로 데이터를 버림.
        if (queue.size() == max) {
            log("[put] 큐가 가득 참, 버림 : " + data);
            return;
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() { // 큐의 데이터를 가져감, 큐에 데이터가 없으면 null 반환
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
