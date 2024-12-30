package Poly.ex6;

public class Bird extends AbstractAnimal implements Fly{
    //상속은 하나만 받을 수 있기에 먼저 extends가 나오고, 그 뒤로 implements가 온다.(인터페이스는 무한정 추가가 되기 때문에)
    @Override
    public void sound() {
        System.out.println("짹짹");
    }

    @Override
    public void fly() {
        System.out.println("새 날기");
    }
}
