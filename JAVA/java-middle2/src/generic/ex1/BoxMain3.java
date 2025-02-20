package generic.ex1;

public class BoxMain3 { // 기본형은 안된다.

    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<Integer>(); // 생성 시점에 T의 타입이 결정이 된다. <>안에 있는게 타입 인자 또는 타입 인수라고 부른다.
        integerBox.set(10); // ctrl + P를 누르면 대입할 수 있는 패러미터 정보가 나온다.
//        integerBox.set("1123"); // Integer 타입만 허용, 컴파일 오류
        Integer integer = integerBox.get();
        System.out.println("integer = " + integer); // Integer 타입 반환 (캐스팅 X) 객체 생성 순간부터 타입이 정해지기 떄문이다.

        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.set("101122");
        String s = stringBox.get();
        System.out.println("s = " + s);

        // 원하는 모든 타입 사용 가능
        GenericBox<Double> doubleBox = new GenericBox<>();
        doubleBox.set(10023.0);
        Double v = doubleBox.get();
        System.out.println("v = " + v);

        // 타입 추론 : 생성하는 제네릭 타입 생략 가능
        GenericBox<Integer> integerBox2 = new GenericBox<>(); // 생성하는쪽에서 생략 가능, 컴파일러가 처리해주는 작업이다. 아무대나 되는것은 아니고 문법상 가능한 곳에서만 가능.
        // 선언하는곳에서 있는 타입을 컴파일에서 확인 후 추론해서 작업을 하는것이다.

    }
}
