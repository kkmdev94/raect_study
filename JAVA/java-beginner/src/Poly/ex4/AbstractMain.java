package Poly.ex4;


public class AbstractMain {

    public static void main(String[] args) {
        //추상클래스 생성 불가
//        AbstractAnimal animal = new AbstractAnimal()

        Dog dog = new Dog();// new Dog -> ctrl + alt + v
        Cat cat = new Cat();
        Caw caw = new Caw();

        dog.sound();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);
        moveAnimal(dog);
        moveAnimal(cat);
        moveAnimal(caw);
    }

    private static void soundAnimal(AbstractAnimal animal) {
        System.out.println("동물 소리 테스트시작");
        animal.sound();
        System.out.println("동물 소리 테스트종료");
        System.out.println();
    }

    private static void moveAnimal(AbstractAnimal animal) {
        System.out.println("동물 이동 테스트시작");
        animal.move();
        System.out.println("동물 이동 테스트종료");
        System.out.println();
    }
}
