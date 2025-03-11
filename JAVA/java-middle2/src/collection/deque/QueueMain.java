package collection.deque;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {

    public static void main(String[] args) {
        Queue<Integer> queqe = new ArrayDeque<>();
//        Queue<Integer> queqe = new LinkedList<>();

        // 데이터 추가
        queqe.offer(1);
        queqe.offer(2);
        queqe.offer(3);
        System.out.println(queqe);

        // 다음 꺼낼 데이터 확인(꺼내지 않고 단순 조회만)
        System.out.println("queqe.peek() = " + queqe.peek());

        // 데이터 꺼내기
        System.out.println("queqe.poll() = " + queqe.poll());
        System.out.println("queqe.poll() = " + queqe.poll());
        System.out.println("queqe.poll() = " + queqe.poll());
        System.out.println(queqe);
    }
}
