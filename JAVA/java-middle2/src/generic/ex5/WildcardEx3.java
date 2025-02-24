package generic.ex5;

import generic.animal.Animal;

public class WildcardEx3 {

    // 타입 매개변수가 꼭 필요한 경우
    // 와일드 카드는 제네릭을 정의할 떄 사용하는것이 아닌 Box<Dog>, Box<Cat> 처럼 타입 인자가 전달된 제네릭 타입을 활용할 때 사용.

    static <T extends Animal> T printAndReturnGenericV3(Box<T> box) {
        T t = box.get();
        System.out.println("t.getName() = " + t.getName());
        return t;
    }

    // 전달한 타입을 명확하게 반환할 수 없다. 여기서는 Animal 타입으로 반환한다.
    static Animal printAndReturnWildcardV3(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
        return animal;
    }
}
