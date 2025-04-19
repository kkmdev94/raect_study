package thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

import static util.MyLogger.log;

public class CasMainV2 {

    public static void main(String[] args) { // 이 메서드는 원자적으로 실행된다는 것이 중요하다.
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = " + atomicInteger.get());

//        int result = atomicInteger.incrementAndGet();
//        System.out.println("result = " + result);
//
//        int result2 = atomicInteger.incrementAndGet();
//        System.out.println("result = " + result2);

        //incrementAndGet 구현
        int resultValue1 = incrementAndGet(atomicInteger);
        System.out.println("resultValue1 = " + resultValue1);

        int resultValue2 = incrementAndGet(atomicInteger);
        System.out.println("resultValue2 = " + resultValue2);
    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;
        do {
            getValue = atomicInteger.get();
            log("getValue = " + getValue);
            result =  atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result = " + result);
        } while (!result);
        return getValue + 1;
    }
}
