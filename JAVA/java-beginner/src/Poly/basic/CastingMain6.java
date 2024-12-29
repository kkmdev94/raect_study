package Poly.basic;

public class CastingMain6 {

    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1");
        call(parent1);

        Parent parent2 = new Child();
        System.out.println("parent2");
        call(parent2);
    }

    private static void call(Parent parent) {
        parent.parentMethod();
        //Child 인스턴스인 경우 childMethod() 실행
        if (parent instanceof Child child) { // -> parent2는 new Child 인스턴스 그러면 -> new Child instanceof Child -> 그러면 Child child = new Child();
            System.out.println("Child");
            child.childMethod();
        }
    }
}
