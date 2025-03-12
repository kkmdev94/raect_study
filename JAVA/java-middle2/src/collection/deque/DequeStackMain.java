package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStackMain {

    public static void main(String[] args) {
        // 데크에서 스택의 메서드도 지원한다.
        Deque<Integer> deque = new ArrayDeque<>();

        //데이터 추가
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        System.out.println(deque);

        // 다음 꺼낼 데이터 확인(꺼내지 않고 단순 조회만)
        System.out.println("deque.peek() = " + deque.peek());

        // 데이터 꺼내기
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println(deque);
    }
}
