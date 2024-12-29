package Poly.ex2;

public class AnimalPolyMain3 {

    public static void main(String[] args) {

        Animal a = new Animal();
        a.sound();

        Animal[] animalArr = {new Dog(), new Cat(), new Caw(), new Pig()};
        //일라인 베리어블 = 변수 선언된 것을 제거하고 합쳐버림 / 단축키 ctrl + alt + N / 비교는 AnimalPolyMain2와 비교해보면 된다
        for (Animal animal : animalArr) {
            soundAnimal(animal); // 원하는 코드 범위를 선택하고 내용을 메서드로 추출 / 단축키는 ctrl + alt + M /
        }
    }
    //동물이 추가되어도 변하지 않는 코드
    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트시작");
        animal.sound();
        System.out.println("동물 소리 테스트종료");
    }
}
