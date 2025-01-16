package lang.wrapper;

public class WrapperUtilsMain {

    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(10); //숫자, 래퍼 객체로 변환
        Integer i2 = Integer.valueOf("10"); // 문자열, 래퍼 객체로 변환
        int intValue = Integer.parseInt("10"); //문자열 전용, 기본형으로 변환 한다. -> 문자열을 기본형으로 전환.

        // 비교
        int compareResult = i1.compareTo(20); // 내 값, 즉 i1 = 10 이니까 10과 인수로 넘어온 20을 비교한다.
        // 내 값이 크면 1, 같으면 0, 작으면 -1을 반환.
        System.out.println("compareResult = " + compareResult);

        // 산술연산
        System.out.println("sum : " + Integer.sum(10, 20)); // static 메서드.
        System.out.println("min : " + Integer.min(10, 20)); // static 메서드.
        System.out.println("max : " + Integer.max(10, 20)); // static 메서드.
    }
}
