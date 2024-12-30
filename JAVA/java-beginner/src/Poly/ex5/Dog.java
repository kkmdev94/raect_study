package Poly.ex5;

public class Dog implements InterfactAnimal{ // extends -> 상속에만 사용.
    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void move() {
        System.out.println("개 이동");
    }
}
