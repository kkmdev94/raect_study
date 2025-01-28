package time;

import java.time.LocalDate;

public class LocalDateMain {

    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2013, 1, 13);
        System.out.println("오늘 날짜 = " + nowDate);
        System.out.println("지정 날짜 = " + ofDate);

        // 계산(불변)
        ofDate = ofDate.plusDays(10); // 불변이라 반환 받아야한다.
        System.out.println("지정날짜 + 10d = " + ofDate);
    }
}
