package Poly.ex2;

public class AnimalPolyMain1 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();
        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);

    }

    private static void soundAnimal(Animal animal) { // Animal animal = dog <-dog는 Dog타입 부모는 자식을 담을 수 있다. / cat, caw도 동일
        System.out.println("동물 소리 테스트시작");
        animal.sound();
        System.out.println("동물 소리 테스트종료");
    }
}
