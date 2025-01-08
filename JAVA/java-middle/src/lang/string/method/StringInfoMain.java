package lang.string.method;

public class StringInfoMain {

    public static void main(String[] args) {
        String str = "Hello, Java!";
        System.out.println("문자열의 길이 : " + str.length());
        System.out.println("문자열의 비어 있는지 : " + str.isEmpty());
        System.out.println("문자열의 공백인지 : " + str.isBlank());
        System.out.println("문자열의 비어 있거나 공백인지 : " + "             ".isBlank());
        //  공백이라는것은 "" <- 아무것도 없다, 비어있다 라는 뜻이다.
        // String 레터럴에서 " 다음부터 0번이다. 즉 위의 Hello, Java에서는 H가 0번 인덱스이다.

        char c = str.charAt(6);
        System.out.println("7번 인덱스의 문자 c =" + c);
    }
}
