package Poly.ex3;

public abstract class AbstractAnimal {

    public abstract void sound(); // 추상 메서드로 무조건 상속받은 자식은 오버라이딩을 해야한다.

    public void move() { //추상 메서드가 아니므로 오버라이딩을 굳이 안해도 되고 해도 된다.
        System.out.println("동물이 움직입니다.");
    }
}
