package Poly.ex5;

public class InterfaceMain {

    public static void main(String[] args) {
        //interfact 생성 불가
//        InterfactAnimal interfactAnimal = new InterfactAnimal();

        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);
        moveAnimal(dog);
        moveAnimal(cat);
        moveAnimal(caw);
    }

    private static void soundAnimal(InterfactAnimal animal) {
        System.out.println("동물 소리 테스트시작");
        animal.sound();
        System.out.println("동물 소리 테스트종료");
        System.out.println();
    }

    private static void moveAnimal(InterfactAnimal animal) {
        System.out.println("동물 이동 테스트시작");
        animal.move();
        System.out.println("동물 이동 테스트종료");
        System.out.println();
    }
}
