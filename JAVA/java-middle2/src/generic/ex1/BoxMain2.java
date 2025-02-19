package generic.ex1;

public class BoxMain2 {

    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.set(10);
//        Object object1 = integerBox.get();
//        Integer integer = (Integer) object1;

        //ctrl + alt + shift + t
        Integer integer = (Integer) integerBox.get(); // Object -> Integer 다운 캐스팅

        System.out.println("integer = " + integer);

        ObjectBox StringBox = new ObjectBox();
        StringBox.set("hello");
        String str = (String) StringBox.get(); //Object -> String 다운 캐스팅
        System.out.println("object2 = " + str);

        // 잘못된 타입의 인수 전달시
        integerBox.set("문자100"); // 문자에서 인티저로 캐스팅하려고 하니 오류가 발생
        Integer reslut = (Integer) integerBox.get(); // String -> Integer 캐스팅 예외
        System.out.println("reslut = " + reslut);
    }

    // 현재 코드에서 문제점
    /*
        1. 반환 타입이 맞이 않는 문제 = Object는 모든 타입을 다 담을 수 있기에 다운 캐스팅에서 문제가 발생 할 수 있다.
        지금까지 개발한 프로그램(예제들)을 보면 코드 재사용과 타입 안정성을 둘다 잡을 수 없었다.
        BoxMain1은 타입별로 클래스를 모두 정의하기에
            - 코드 재사용 X
            - 타입 안정성 O
        BoxMain2는 Object를 사용해 다형성으로 하나의 클래스만 정의하였기에
            - 코드 재사용 O
            - 타입 안정성 X
     */
}
