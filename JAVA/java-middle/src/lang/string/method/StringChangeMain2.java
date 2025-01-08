package lang.string.method;

public class StringChangeMain2 {

    public static void main(String[] args) {
        String strWithSpaces = "     Java Programming  ";

        System.out.println("소문자 변환 : " + strWithSpaces.toLowerCase());
        System.out.println("대문자 변환 : " + strWithSpaces.toUpperCase());

        System.out.println("공백 제거(trim) : '" + strWithSpaces.trim() + "'"); //문자열 양쪽 끝 스페이스바만 제거 가능
        System.out.println("공백 제거(strip) : '" + strWithSpaces.strip() + "'"); // 스페이스바 와 유니코드 공백 제거 가능(Java 11부터 지원)
        System.out.println("앞 공백 제거(strip) : '" + strWithSpaces.stripLeading() + "'"); // 앞공백 제거
        System.out.println("뒤 공백 제거(strip) : '" + strWithSpaces.stripTrailing() + "'"); // 뒷공백 제거
    }
}
