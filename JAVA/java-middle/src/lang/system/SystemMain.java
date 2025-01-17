package lang.system;

import java.util.Arrays;
import java.util.Map;

public class SystemMain {

    public static void main(String[] args) {
        // 현재 시간(밀리초)를 가져온다.
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        //현재 시간(나노초)를 가져온다.
        long nanoTime = System.nanoTime();
        System.out.println("nanoTime = " + nanoTime);

        // 환경 변수를 읽는다. -> 시스템의 환경 변수들을 세팅하는 것. / 운영체제가 사용하는 거
        System.out.println("getenv= " + System.getenv());

        // 시스템 속성을 읽는다. -> 자바가 사용하는 것.
        System.out.println("properties = " + System.getProperties());
        System.out.println("Java version : " + System.getProperty("java.version"));

        // 배열을 고속으로 복사한다.
        char[] originalArray = {'h', 'e', 'l', 'l', 'o'};
        char[] copiedArray = new char[5];
        System.arraycopy(originalArray,0, copiedArray, 0, originalArray.length);

        // 배열 출력
        System.out.println("copiedArray = " + copiedArray);
        System.out.println("copiedArray = " + Arrays.toString(copiedArray));

        // 프로그램 종료 -> 가급적이면 사용을 권장하지 않음.
        System.exit(0);
        System.out.println("hello");
    }
}
