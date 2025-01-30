package time;

import java.time.Instant;
import java.time.ZonedDateTime;

public class InstantMain {

    public static void main(String[] args) {
        // 생성
        Instant now = Instant.now(); //UTC 기준
        System.out.println("now = " + now);

        ZonedDateTime zdt = ZonedDateTime.now();
        Instant from = Instant.from(zdt);
        System.out.println("from = " + from);

        Instant epochStart = Instant.ofEpochSecond(0); // 시작점인 1970-1-1 00:00:00분 부터 시작해서 ()안의 숫자(초)만큼 더한 값을 구한다.
        System.out.println("epochStart = " + epochStart);

        // 계산
        Instant laste = epochStart.plusSeconds(3600);
        System.out.println("laste = " + laste);

        //조회
        long epochSecond = laste.getEpochSecond();
        System.out.println("epochSecond = " + epochSecond);
    }
}
