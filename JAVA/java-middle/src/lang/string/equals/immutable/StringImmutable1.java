package lang.string.equals.immutable;

public class StringImmutable1 {

    public static void main(String[] args) {
        String str = "hello";
        str.concat(str);
        System.out.println(str + str);
    }
}
