package generic.ex3;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV3 {

    public static void main(String[] args) {
        AnimalHospitalV3<Dog> dogHospital = new AnimalHospitalV3<>();
        AnimalHospitalV3<Cat> catHospital = new AnimalHospitalV3<>();
//        AnimalHospitalV3<Integer> integerAnimalHospitalV3 = new AnimalHospitalV3<Integer>(); // -> Animal이거나 Animal의 자식이 아니기에 컴파일 오류

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 200);

        // 개 병원
        dogHospital.set(dog);
        dogHospital.checkup();

        // 고양이 병원
        catHospital.set(cat);
        catHospital.checkup();

        // 문제 1: 개 병원에 고양이 전달
//        dogHospital.set(cat); // 다른 타입 입력 : 컴파일 오류

        // 문제 2: 개 타입 반환
        dogHospital.set(dog);
        Dog dogBigger = dogHospital.bigger(new Dog("멍멍이2", 200));
        System.out.println("dogBigger = " + dogBigger);
    }
}
