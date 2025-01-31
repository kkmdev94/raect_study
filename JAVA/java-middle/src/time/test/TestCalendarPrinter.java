package time.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class TestCalendarPrinter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("년도를 입력하세요 : ");
        int year = sc.nextInt();
        System.out.print("월을 입력하세요 : ");
        int month = sc.nextInt();

        LocalDate cal = LocalDate.of(year, month, 1);
        LocalDate lastDayOfWeek = cal.with(TemporalAdjusters.lastDayOfMonth());
//        System.out.println("lastDayOfWeek = " + lastDayOfWeek);


    }
}
