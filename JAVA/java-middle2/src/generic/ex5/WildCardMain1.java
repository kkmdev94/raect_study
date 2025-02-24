package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildCardMain1 {

    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();
        dogBox.set(new Dog("멍멍이", 100));

        // 제네릭 메서드 사용
        WildcardEx.printGenericV1(dogBox);
//      WildcardEx1.printWildcardV1(dogBox);
        WildcardEx.printGenericV2(dogBox);
//      WildcardEx2.printWildcardV2(dogBox);

        Dog dog = WildcardEx.printAndReturnGenericV2(dogBox);

        Cat cat = WildcardEx.printAndReturnGenericV2(catBox);

        Animal animal = WildcardEx3.printAndReturnWildcardV3(dogBox);


    }
}
