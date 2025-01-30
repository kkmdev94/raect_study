package time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JonedDateTimeMain {

    public static void main(String[] args) {
        ZonedDateTime nowZdt = ZonedDateTime.now();
        System.out.println("nowZdt = " + nowZdt);

        LocalDateTime ldt = LocalDateTime.of(2030, 1, 1, 13, 39, 59);
        ZonedDateTime zdt1 = ZonedDateTime.of(ldt, ZoneId.of("Asia/Seoul"));
        System.out.println("zdt1 = " + zdt1);

        ZonedDateTime zdt2 = ZonedDateTime.of(2030, 1, 1, 13, 30, 50,0,ZoneId.of("Asia/Seoul"));
        System.out.println("zdt2 = " + zdt2);

        ZonedDateTime utcZdt = zdt2.withZoneSameInstant(ZoneId.of("UTC"));// 내 시간은 한국시간으로 9시인데 영국은 몇시일까? 하는 의문에서 영국시간을 확인하는 방법
        System.out.println("utcZdt = " + utcZdt);

        ZonedDateTime utcZdt2 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime utcZdt3 = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("utcZdt2 = " + utcZdt2);
        System.out.println("utcZdt3 = " + utcZdt3);

    }
}
