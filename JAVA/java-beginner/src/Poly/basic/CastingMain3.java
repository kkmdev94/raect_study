package Poly.basic;

//upcasting vs downcasting
public class CastingMain3 {

    public static void main(String[] args) {
        Child child = new Child();
        Parent parent1 = (Parent) child; //업 캐스팅은 생략 가능, 생략 권장 / 부모는 자식을 담을 수 있기에 생략 가능. 생략도 권장함
        Parent parent2 = child; // 업 캐스팅 생략

        parent1.parentMethod();
        parent2.parentMethod();
    }
}
