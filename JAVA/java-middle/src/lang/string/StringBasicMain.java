package lang.string;

public class StringBasicMain {

    public static void main(String[] args) {
        String str1 = "hello"; // -> 앞에 대문자로 시작 == 클래스이다.
        String str2 = new String("hello");

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
    }
}
