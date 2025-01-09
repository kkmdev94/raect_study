package lang.string.ex;

public class TestString2 {

    public static void main(String[] args) {
        String[] arr = {"hello", "java", "jvm", "spring", "jpa"};
        int sum = 0;

        for (String s : arr) {
            System.out.println(String.format("%s : ",s) + s.length());
//            System.out.println(s + " : " + s.length()); // 선생님 답안.
            sum += s.length();
        }
        System.out.println("sum = " + sum);
    }
}
