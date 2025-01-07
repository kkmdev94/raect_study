package lang.string;

public class CharArrayMain {

    public static void main(String[] args) {
        char a = '가';
        System.out.println("a = " + a );

        // 여러개의 문자를 받는 법
        char[] charArr = new char[]{'h','e','l','l','o'};
        System.out.println(charArr);

        // String 사용
        String str = "hello";
        System.out.println("str = " + str);
    }
}
