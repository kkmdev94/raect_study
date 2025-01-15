package lang.wrapper;

public class WrapperClassMain {

    public static void main(String[] args) {
        Integer newInteger = new Integer(10);
        // 빨간줄이 그여있는 것을 따라 가보면, Deprecateddl 적혀있는데 이것은 미래에 삭제 예정이니 대체제를 사용해라 라는 뜻
        // 대체제로 valueOf()를 사용해라 라고 표시되어있다. / 하지만 호환성을 너무나도 중요하게 여기는 자바이기에 언제 삭제될지는 모른다.
        Integer integerObj = Integer.valueOf(10); // -128 ~ 127 자주 사용하는 숫자 값 재사용, 불변 / 문자열 풀 처럼 미리 만들어놓은것을 불러온다.
        Long longObj = Long.valueOf(100); // 래퍼 클래스를 다루는것은 기본형을 다루는것과 비슷하다.
        Double dobuleObj = Double.valueOf(10.5);
        System.out.println("newInteger = " + newInteger);
        System.out.println("integerObj = " + integerObj);
        System.out.println("longObj = " + longObj);
        System.out.println("dobuleObj = " + dobuleObj);

        System.out.println("내부 값 읽기");
        int intObj = integerObj.intValue();
        System.out.println("intObj = " + intObj);
        long longValue = longObj.longValue();
        System.out.println("longValue = " + longValue);

        System.out.println("비교");
        System.out.println("=="); // <- 들어가면 안됨. 참조값이 다름
        System.out.println("equals: " + newInteger.equals(integerObj));
    }
}
