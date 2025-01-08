package lang.string.method;

public class StringUtilsMain1 {

    public static void main(String[] args) {
        int num = 100;
        boolean bool = true;
        Object obj = new Object();
        String str = "Hello, Java!";

        // valueOf 메서드
        String numString = String.valueOf(num);
        System.out.println("숫자의 문자열 값 : " + numString);

        String boolString = String.valueOf(bool);
        System.out.println("불린형의 문자열 값 : " + boolString);

        String objString = String.valueOf(obj);
        System.out.println("객체의 문자열 값 : " + objString);

        String numString2 = "" + num; // -> 문자 + x -> 문자
        String numString3 = "aa" + num; // -> 문자열 + x -> 문자
        System.out.println("빈문자열 + num : " + numString2);
        System.out.println("빈문자열 + num : " + numString3);

        // toCharArray 메서드
        char[] strCharArray = str.toCharArray();
        System.out.println("문자열을 문자 배열로 변환: " + strCharArray);
        for (char c : strCharArray) {
            System.out.print(c); // 문자를 하나씩 찍어내기에 ln을 붙이면 한글자씩 한줄에 나온다.
        }
        System.out.println();
    }
}
