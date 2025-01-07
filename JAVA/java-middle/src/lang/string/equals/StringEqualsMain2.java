package lang.string.equals;

public class StringEqualsMain2 {

    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("메서드 호출 비교1 : " + isSame(str1,str2));

        String str3 = "hello";
        String str4 = "hello";
        System.out.println("메서드 호출 비교2 : " + isSame(str3,str4));
    }

    private static boolean isSame(String x, String y) {
//        return x == y;
//        문자열을 비교하는 메서드를 만드는 개발자는 x, y 가 new String으로 올지 리터럴로 올지 모른다. 그래서 ==로 비교하면 안된다.
        return x.equals(y);
    }
}
