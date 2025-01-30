package time;

import java.time.Duration;
import java.time.LocalTime;

public class DurationMain {

    public static void main(String[] args) {
        // Period(년,월,일)에서의 메서드는 get이지만 Durtion(시,분,초,나노초)에서 시간과 분은 to로 시작한다.
        // 그 이유는 get은 반환, to는 계산이 필요해서인데 Durtion을 보면 초와 나노초만 반환을 하고, 시간과 분은 초를 나누어서 계산하여 반환하기에
        // toHour와 toMinutes가 메서드로 존재한다.

        Duration duration = Duration.ofMinutes(30);
        System.out.println("duration = " + duration);

        LocalTime lt = LocalTime.of(1, 0);
        System.out.println("lt = " + lt);

        //계산에 사용
        LocalTime plusTime = lt.plus(duration);
        System.out.println("더한 시간 : " + plusTime);

        // 시간 차이
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(10, 0);
        Duration between = Duration.between(start, end);
        System.out.println("차이 : " + between.getSeconds());
        System.out.println("근무 시간 : " +  between.toHours() + "시간" + between.toMinutesPart() + "분");
        System.out.println("근무 시간 : " +  between.toHours() + "시간" + between.toMinutes() + "분");
        // minutes와 minutesPart의 차이 : minutes는 전체 분을 다 알려주고, minutesPart는 시간을 제외하고 남은 분만 알려준다.(몇시 몇분할때의 그 몇분을 표시해주는것이다.)
    }
}
