package lang.string.ex;

public class TestString11 {

    public static void main(String[] args) {
//        String str = "Hello Java";
//        StringBuilder strs = new StringBuilder(str);
//        StringBuilder reverseString = strs.reverse();
//        System.out.println("reverseString = " + reverseString);

        StringBuilder str = new StringBuilder("Hello Java");
        StringBuilder reversess = str.reverse();
        String str1 = reversess.toString();
        System.out.println(str1);

        //선생님 정답 (메서드 체이닝을 생각하지 못했다.)
//        String str = "Hello Java";
//        String strs = new StringBuilder(str).reverse().toString();
//        System.out.println("strs = " + strs);
    }
}
