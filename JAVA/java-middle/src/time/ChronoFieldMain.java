package time;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class ChronoFieldMain {

    public static void main(String[] args) {
        //필드란 ? : 뭔가 각각의 항목을 뜻한다. / 연도를 보면 연,월,일 이렇게 세 개 항목으로 쪼개져 있는 것이다. 예시로 단순히 16일 이라고 하면 이게 몇월의 16일인지, 몇년도의 16일인지 모른다.
        // 그래서 MONTH_OF_YEAR는 해당 연에 해당 월을 뜻하는것이고 DAY_OF_MONTH는 해당 월의 해당일을 뜻한다.
        // 단순히 시간의 단위 하나하나를 뜻하는 ChronoUnit과는 다르게 ChronoField를 사용해 날짜와 시간의 각 필드 중에 원하는 데이터를 조회할 수 있다.
        // 필드의 인터페이스는 대부분 특정부분을 지정하는 것이 많다.
        ChronoField[] values = ChronoField.values();
        for (ChronoField value : values) {
            System.out.println("value = " + value + ", range = " + value.range());
        }

        System.out.println("ChronoField.MONTH_OF_YEAR.range() = " + ChronoField.MONTH_OF_YEAR.range());
        System.out.println("ChronoField.DAY_OF_MONTH.range() = " + ChronoField.DAY_OF_MONTH.range());
    }
}
