package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingMain1 {

    public static void main(String[] args) {
        // 포맷팅 : 날짜와 시간 데이터를 원하는 포맷의 문자열로 변경, Date -> String
        // 파싱 : 문자열을 날짜와 시간 데이터로 변경, String -> Date

        //포맷팅
        LocalDate date = LocalDate.of(2024, 12, 31);
        System.out.println("date = " + date);
//        System.out.println(date.getYear() + "년 " + date.getMonthValue() + "월 ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String formattedDate = date.format(formatter);
        System.out.println("formattedDate = " + formattedDate);

        //파싱
        String input = "2030년 01월 01일";
        LocalDate parsed = LocalDate.parse(input, formatter); // Formatter를 만들어 놔야된다.
        System.out.println("parsed = " + parsed);
    }
}
