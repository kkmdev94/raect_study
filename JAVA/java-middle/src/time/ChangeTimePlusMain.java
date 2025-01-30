package time;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ChangeTimePlusMain {

    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2018, 1, 1, 13, 30, 59);
        System.out.println("dt = " + dt);

        LocalDateTime plusDt1 = dt.plus(10, ChronoUnit.YEARS);
        // (얼만큼 늘릴꺼야? , 어떤 유닛(단위)로 늘릴꺼야?) -> 즉 지금 예시는 년수를 10년 늘리겟다는 것이다.
        // plus 뿐만 아니라 마이너스 등도 지원한다.
        System.out.println("plusDt1 = " + plusDt1);

        LocalDateTime plusDt2 = dt.plusYears(10); // 편의 메서드 제공
        System.out.println("plusDt2 = " + plusDt2);

        Period period = Period.ofYears(10);
        LocalDateTime plusDt3 = dt.plus(period);
        System.out.println("plusDt3 = " + plusDt3);
    }
}
