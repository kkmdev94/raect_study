package time;

import java.time.ZoneId;
import java.util.Set;

public class JoneIdMain {

    public static void main(String[] args) {
        for (String availableZoneIds : ZoneId.getAvailableZoneIds()) {
            ZoneId zoneId = ZoneId.of(availableZoneIds);
            System.out.println(zoneId + " | " + zoneId.getRules()); // 모든 시간에 대한 UTC를 알려줌
        }

        ZoneId zoneId = ZoneId.systemDefault(); // 현재 운영체제의 시간 기준 정보를 알려줌
        System.out.println("zoneId.systemDefault = " + zoneId);

        ZoneId seoulzoneId1 = ZoneId.of("Asia/Seoul");
        System.out.println("seoulzoneId1 = " + seoulzoneId1);
    }
}
