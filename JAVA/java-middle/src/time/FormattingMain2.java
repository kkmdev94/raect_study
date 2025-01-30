package time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingMain2 {

    public static void main(String[] args) {
        // 포맷팅 : 날짜와 시간을 문자로
        LocalDateTime ldt = LocalDateTime.of(2024, 12, 31, 13, 30, 59);
        System.out.println("ldt = " + ldt);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = ldt.format(formatter);
        System.out.println("format = " + format);

        // v파싱 : 문자를 날짜와 시간으로
        String dateTimeString = "2303-01-01 11:30:17";
        LocalDateTime parsed = LocalDateTime.parse(dateTimeString, formatter);
        System.out.println("parsed = " + parsed);
    }
}
