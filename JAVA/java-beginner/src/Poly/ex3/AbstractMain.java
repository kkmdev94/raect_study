package Poly.ex3;


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
    }

    private static void soundAnimal(AbstractAnimal animal) {
        System.out.println("동물 소리 테스트시작");
        animal.sound();
        animal.move();
        System.out.println("동물 소리 테스트종료");
        System.out.println();
    }
}
