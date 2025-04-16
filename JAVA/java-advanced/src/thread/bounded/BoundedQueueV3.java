package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedQueueV3 implements BoundedQueue{
    /* wait(), notify(), notifyAll() 은 Object의 메서드로서, Object는 모든 것의 부모이기에 모든것을 담을 수 있다.
    따라서, wait()는 스레드 대기 집합을 통해 락을 반납하고 대기 할 수 있으며 notify()는 스레드 대기 집합에 있는 것을 깨울 수 있다.
    이로 인해 Thread를 제어 할 수 있는 자료 구조를 완성했지만, 이 방식의 단점은 '스레드 대기 집합이 하나'라는 것이다
    스레드 대기 집합이 하나이기에 원하는것을 깨울 수 없으며(소비자가 생산자를 / 생산자가 소비자를) 이로인해 약간의 비효율이 발생한다(로직이 작동하는데에는 문제가 없다)
    */

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV3(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while (queue.size() == max) {
            log("[put] 큐가 가득 참, 생산자 대기");
            try {
                wait(); // RUNNABLE -> WAITING 상태로 변경 / 락 반납
                log("[put] 생산자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(data);
        log("[put] 생산자 데이터 저장, notify() 호출");
        notify(); // 대기 스레드, WAIT -> BLOCKED
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[take] 큐에 데이터가 없음, 소비자 대기");
            try {
                wait();
                log("[take] 소비자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String data = queue.poll();
        log("[take] 소비자 데이터 획득, notify() 호출");
        notify(); // 대기 스레드, WAIT -> BLOCKED
        return data;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
