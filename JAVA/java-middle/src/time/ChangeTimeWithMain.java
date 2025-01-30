package time;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class ChangeTimeWithMain {

    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2018, 1, 1, 13, 30, 59);
        System.out.println("dt = " + dt);

        LocalDateTime changeDt1 = dt.with(ChronoField.YEAR, 2020);
        System.out.println("changeDt1 = " + changeDt1); // 새로운 객체를 만들어서 변환 = with

        // 편의 메서드
        LocalDateTime chagneDt2 = dt.withYear(2020);
        System.out.println("chagneDt2 = " + chagneDt2);

        // TemporalAdjuster 사용 -> 모든것은 생성한 인스턴스를 기준으로 한다. = 지금 이 예제에서는 dt를 기준으로 한다.
        // TemporalAdjuster의 인터페이스를 구현해 놓고 TemporalAdjusters에 모든 기능을 담아 놓았다. 그래서 뒤에 s를 붙혀서 사용하면 된다.
        // 다음주 금요일
        LocalDateTime with1 = dt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("기준 날짜 : " + dt);
        System.out.println("다음 금요일 : " + with1);

        // 이번 달의 마지막 일요일
        LocalDateTime with2 = dt.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println("with2 = " + with2);
    }
}
