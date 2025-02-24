package generic.ex5;

import generic.animal.Animal;

public class WildcardEx2 {

    static <T extends Animal> void printGenericV2(Box<T> box) {
        T t = box.get();
        System.out.println("t.getName() = " + t.getName());
    }

    // 상한 와일드 카드
    // 반환은 상한타입의 최대 부모인 Animal이 된다.
    static void printWildcardV2(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
    }
}
