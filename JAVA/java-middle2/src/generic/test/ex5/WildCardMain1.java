package generic.test.ex5;

import generic.animal.Cat;
import generic.animal.Dog;

public class WildCardMain1 {

    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();
        dogBox.set(new Dog("멍멍이", 100));

        /* 제네릭 메서드 사용
        WildcardEx.printGenericV1(dogBox);
        WildcardEx.printGenericV2(dogBox);
        WildcardEx.printAndReturnGenericV2(dogBox);
         */
        WildcardEx.printWildcardV1(dogBox);
        WildcardEx.printWildcardV2(dogBox);
        WildcardEx.printAndReturnWildcardV3(dogBox);
    }
}
