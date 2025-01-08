package lang.string.method;

public class StringUtilsMain2 {

    public static void main(String[] args) {
        int num = 100;
        boolean bool = true;
        String str = "Hello, Java!";

        // format 메서드
        String format1 = String.format("num: %d, bool: %b, str: %s", num, bool, str);
        // 각각 숫자는 %d, boolean은 %b, 문자는 %s로 지정하고 그 뒤에 옳바른 순서로 나열하면 각 %d, %b, %s에 값을 넣어준다.
        System.out.println(format1);

        String format2 = String.format("숫자: %.2f", 10.1234);
        System.out.println(format2);

        // printf
        System.out.printf("숫자 : %.2f\n", 10.1234);

        // matches -> 정규 표현식 (따로 공부해야 이해 가능 레귤러 익스프레션이라고 한다)
        // 그냥 자바에서도 이런걸 지원한다 라는 것만 인지하고 추후 공부나 찾아보면 된다.
        String regex = "Hello, (Java!|World)";
        System.out.println("'str'이 패턴과 일치하는가? " + str.matches(regex));
    }
}
