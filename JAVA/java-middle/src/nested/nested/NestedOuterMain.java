package nested.nested;

public class NestedOuterMain {

    public static void main(String[] args) {
//        NestedOuter outer = new NestedOuter();
//        NestedOuter(바깥 클래스)와 정적 중첩 클래스인 Nested는 서로 아무관계도 없다. 클래스 구조상 중첩해 둘 수 있을뿐. 없어도 된다.
//        바깥 클래스와 정적 중첩 클래스(static class)는 서로 다른 인스턴트이다.
        NestedOuter.Nested nested = new NestedOuter.Nested();
        nested.print();

        System.out.println("nested = " + nested.getClass());
    }
}
/*
정적 중첩 클래스는 사실 다른 클래스를 그냥 중첩해 둔 것 뿐이다. NestedOuter와 Nested는 아무런 상관이 없는 서로 다른 인스턴트이다 다만 이것을 사용하는 이유는
같은 클래스에 존재하여 private 접근 제어자에 접근할 수 있다는 것이다.(단, 정적 중첩 클래스는 static이라 static이 붙지 않은 변수는 참고할 수 없다./ 참조값을 알 수 없기에 static이 붙지 않은것은
참조할 수 없기 때문에 애초에 static 객체는 static이 붙지 않은거에 접근할 수 없다.)
 */