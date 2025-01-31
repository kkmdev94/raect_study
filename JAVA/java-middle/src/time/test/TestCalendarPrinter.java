package time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class TestCalendarPrinter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("년도를 입력하세요 : ");
        int year = sc.nextInt();
        System.out.print("월을 입력하세요 : ");
        int month = sc.nextInt();
        sc.nextLine();

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate lastDayOfWeek = startDate.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println("Su Mo Tu We Th Fr Sa ");
        for (int i = 0; i < startDate.lengthOfMonth(); i++) {
            if (i==0) {
                for (int j = 0; j < startDate.getDayOfWeek().getValue(); j++) {
                    System.out.print("   ");
                }
            }
            LocalDate date = startDate.plusDays(i);
            System.out.printf("%2d ",date.getDayOfMonth());
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                System.out.println();
            }
        }
    }
}
