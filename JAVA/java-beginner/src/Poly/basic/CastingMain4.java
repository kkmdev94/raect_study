package Poly.basic;

//다운캐스팅을 자동으로 하지 않는 이유
public class CastingMain4 {

    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1;
        child1.childMethod();

//        Parent parent2 = new Parent();
//        Child child2 = (Child) parent2; // 런타임 오류 - ClassCastException
//        child2.childMethod(); // 실행 불가

        // parent2는 부모 인스턴스를 생성했기에 Child 자체가 인스턴스에 생성이 안된다 그래서 찾지를 못한다.

        //Child child3 = new Parent(); // 컴파일 오류 / 자식은 부모를  담을 수 없다.
        //Child child4 = (Child) new Parent(); // 런타임 오류
        // 부모 인스턴스에는 자식이 존재하지 않기 때문에 Child 타입(자식)이 인스턴스에 생성이 안된다. 그래서 타입을 찾지 못하고 캐스팅 오류가 발생.

    }
}
