package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedQueueV2 implements BoundedQueue{
    /* synchronized로 인해 동기화가 이루어지고 스레드는 하나만 락을 가지고 들어올 수 있기 때문에.
    생산자가 먼져 실행되면 데이터를 넣지도 버리지도 못하고 공간이 나올때까지 무한대기가 걸리고 소비자는 생산자가 락을 가지고 있기에 진입하지 못하고 블록이 된다.
    소비자가 먼져 실행되면 데이터를 가져와야 되는데 데이터가 없으니 가져오지 못하고, 1번 소비자부터 락을 가지고 빠져나오지 못하기에 블록이 되고 무한 대기를 이룬다.
    */

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV2(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while (queue.size() == max) {
            log("[put] 큐가 가득 참, 생산자 대기");
            sleep(1000);
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[take] 큐에 데이터가 없음, 소비자 대기");
            sleep(1000);
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
