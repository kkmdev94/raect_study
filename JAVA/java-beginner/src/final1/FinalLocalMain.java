package final1;

public class FinalLocalMain {

    public static void main(String[] args) {
        //final 지역 변수
        final int data1;
        data1 = 10; // 최초 한번만 할당 가능
//        data1 = 20; // 컴파일 오류 -> 파이널은 최초에 딱 한번만 할당이 가능하다

        //final 지역 변수 2
        final int data2 = 10;
//        data2 = 20; // 컴파일 오류 -> 이유는 같다 선언과 동시에 초기화 -> 할당까지 했기에
        method(10); // 파라매터로 값을 받기에 / 즉 이거는 x001
        method(20); // 새로운 참조값(매개 변수)을 호출한거기에 가능하다 / 이거는 x002라고 보면된다.
    }

    static void method(final int parameter) {
//        parameter = 20; // 해당 값은 이미 메소드 호출시 참조값(매개 변수)으로 받기에 변경 할 수 없다. 그래서 해당 메서드 안에서 변경을 하고싶어도 컴파일 오류가 발생
        System.out.println(parameter);
    }
}
