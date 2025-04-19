package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasMainV1 {

    public static void main(String[] args) { // 이 메서드는 원자적으로 실행된다는 것이 중요하다.
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("atomicInteger.get() = " + atomicInteger.get());

        boolean result1 = atomicInteger.compareAndSet(0, 1); // 우리가 기대하는 값이 0이면 1로 셋팅해라 라는 것.
        System.out.println("result1 = " + result1 + ", value = " + atomicInteger.get()); // 1

        boolean result2 = atomicInteger.compareAndSet(0, 1); // 내가 지정한 값을 비교해서 true면 설정한 값으로 바꾸고 아니면 false를 바꾸고 값을 변경하지 않는다.
        System.out.println("result2 = " + result2 + ", value = " + atomicInteger.get());
    }
}
