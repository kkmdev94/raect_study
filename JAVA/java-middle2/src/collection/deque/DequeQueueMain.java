package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeQueueMain {

    public static void main(String[] args) {
        // 데크에서는 큐의 메서드도 지원한다.
        Deque<Integer> deque = new ArrayDeque<>();

        // 데이터 추가
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println(deque);

        // 다음 꺼내질 데이터 확인(꺼내지 않고 조회만)
        System.out.println("deque.peek() = " + deque.peek());

        // 데이터 꺼내기
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println(deque);
    }
}
