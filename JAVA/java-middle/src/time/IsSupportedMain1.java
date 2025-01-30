package time;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class IsSupportedMain1 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now(); // LocalDate에는 연,월,일만 있고 시,분,초는 없다.
        int minute = now.get(ChronoField.SECOND_OF_MINUTE); // 그래서 시, 분 , 초를 꺼내려 하면 예외가 발생한다.
        System.out.println("minute = " + minute);
    }
}
