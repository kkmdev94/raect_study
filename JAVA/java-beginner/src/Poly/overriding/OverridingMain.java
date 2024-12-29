package Poly.overriding;

public class OverridingMain {

    public static void main(String[] args) {
        //자식 변수가 자식 인스턴스 참조
        Child child = new Child();
        System.out.println("Child -> Child");
        System.out.println("value = " + child.value);
        child.method();

        System.out.println();

        //부모 변수가 부모 인스턴스 참조
        Parent parent = new Parent();
        System.out.println("Parent -> Parent");
        System.out.println("value = " + parent.value);
        parent.method();

        //부모 변수가 자식 인스턴스 참조(다형적 참조)
        Parent poly = new Child();
        System.out.println("Parent -> Child");
        System.out.println("value = " + poly.value); //변수는 오버라이딩X
        poly.method(); //메서드 오버라이딩! / 타입은 부모타입이지만 오버라이딩된 메서드는 우선권을 가지기에 자식의 메서드가 호출된다.
        ((Child) poly).pmethod();
        // 타입이 부모타입이라 다운캐스팅을 해야한다. 인스턴스 내부에서는 child와 parent가 전부 생성되어 있지만 타입이 부모라 child의 메서드를 찾아갈 수 없다.
        // 그래서 다운캐스팅을 통해 child 타입으로 변경하여 super를 사용한 부모메서드를 호출하는 것이다.

    }
}
