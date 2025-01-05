package lang;

//import java.lang.System; 생략 가능

public class LangMain {

    public static void main(String[] args) {
        System.out.println("hello java");
        System.out.println(12345);
        int i = 100;

        String value = Integer.toHexString(System.identityHashCode(i));
        System.out.println("value = " + value);

        System.out.println("11 = " + System.identityHashCode(10));
    }
}
