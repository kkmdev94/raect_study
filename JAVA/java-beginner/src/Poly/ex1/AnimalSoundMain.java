package Poly.ex1;

public class AnimalSoundMain {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

//        Caw[] cawArr = {dog, cat, caw}; // Type이 다르다.

        System.out.println("동물 소리 테스트시작");
        dog.sound();
        System.out.println("동물 소리 테스트종료");

        System.out.println("동물 소리 테스트시작");
        cat.sound();
        System.out.println("동물 소리 테스트종료");

        soundCaw(caw);
    }

    private static void soundCaw(Caw caw) { // 매개 변수에서 Type이 다른 cat이나 dog는 받지 못한다.
        System.out.println("동물 소리 테스트시작");
        caw.sound();
        System.out.println("동물 소리 테스트종료");
    }
}
