package lang.string.method;

public class StringComparisonMain {

    public static void main(String[] args) {
        String str1 = "Hello, Java!"; // 대문자 일부 있음
        String str2 = "hello, java!"; // 대문자 없음
        String str3 = "Hello, World!";

        System.out.println("str1 equals str2: " + str1.equals(str2));
        System.out.println("str1 equals str2: " + str1.equalsIgnoreCase(str2)); // 대소문자를 무시한다.

        System.out.println("'b' compareTo 'a' : " + "b".compareTo("a"));
        System.out.println("'c' compareTo 'a' : " + "c".compareTo("a"));
        System.out.println("'a' compareTo 'b' : " + "a".compareTo("b"));
        // 사전적으로 a와 b의 차이를 알려준다 즉, a와 b는 한칸차이 a와 c는 두칸차이 나는 것이다.

        System.out.println("str1 compareTo str3: " + str1.compareTo(str3));
        System.out.println("str1 compareToIgnoreCase str3: " + str1.compareToIgnoreCase(str2));

        System.out.println("str1 start with 'Hello' : " + str1.startsWith("Hello"));
        System.out.println("str1 ends with 'Hello' : " + str1.endsWith("Java!"));
    }
}
