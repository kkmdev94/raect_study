package time.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestZone {

    public static void main(String[] args) {
        LocalDateTime ldt1 = LocalDateTime.of(2024, 1, 1, 9, 0, 0);
        ZonedDateTime zdt1 = ZonedDateTime.of(ldt1, ZoneId.of("Asia/Seoul"));
        ZonedDateTime zdt2 = zdt1.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime zdt3 = zdt1.withZoneSameInstant(ZoneId.of("America/New_York"));

        System.out.println("서울의 회의 시간 : " + zdt1);
        System.out.println("런던의 회의 시간 : " + zdt2);
        System.out.println("뉴욕의 회의 시간 : " + zdt3);
    }
}
