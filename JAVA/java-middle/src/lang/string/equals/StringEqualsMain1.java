package lang.string.equals;

public class StringEqualsMain1 {

    public static void main(String[] args) {
        String str1 = new String("hello"); //x001
        String str2 = new String("hello"); //x002
        System.out.println("new String() == 비교 : " + (str1 == str2));
        // 참조값의 주소가 str1과 str2가 다르기 때문에 당연히 false 값이 나온다.
        System.out.println("new String() equals 비교 : " + str1.equals(str2));
        /* value의 값으로 비교한다. 즉 논리적으로 볼때 hello와 hello는 같다.
        String에서 제공하는 equals()를 보면 되게 복잡하긴 한데 오버라이딩을 통해
        byte[] 배열을 가지고 안에 있는 문자열(hello)를 비교해서 같은지 확인 후 출력을 하는것이다.
        즉, 안에있는 value의 값을 가지고 비교하는 것이다.
         */

        String str3 = "hello"; // <- String에서 이렇게 그냥 적는 것을 리터럴이라고 한다.
        String str4 = "hello";
        System.out.println("리터럴 == 비교 : " + (str3 == str4));
        System.out.println("리터럴 equals 비교 : " + str3.equals(str4));
    }
}
