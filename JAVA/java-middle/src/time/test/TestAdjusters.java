package time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TestAdjusters {

    public static void main(String[] args) {
        int year = 2024;
        int month = 1;

        LocalDate ld = LocalDate.of(year, month, 1);
        LocalDate firstDayOfWeek = ld.with(TemporalAdjusters.next(DayOfWeek.of(ld.getDayOfMonth())));
        LocalDate lastDayOfWeek = ld.with(TemporalAdjusters.lastDayOfMonth());

        // 선생님 풀이
//        DayOfWeek firstDayOfWeek = ld.getDayOfWeek();
//        DayOfWeek lastDayOfWeek = ld.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();

        System.out.println("firstDayOfWeek = " + firstDayOfWeek.getDayOfWeek());
        System.out.println("lastDayOfWeek = " + lastDayOfWeek.getDayOfWeek());
    }
}
