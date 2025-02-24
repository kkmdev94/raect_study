package generic.test.ex5;

import generic.animal.Animal;

public class WildcardEx {

    /* 제네릭 메서드를 이용해서 작업을 진행했지만 이렇게 제네릭 메서드를 쓰지 않고 족므더 간단히 사용하는 방법
    static <T> void printGenericV1(Box<T> box) {
        System.out.println("T = " + box.get());
    }
    static <T extends Animal> void printGenericV2(Box<T> box) {
        T t = box.get();
        System.out.println("t.getName() = " + t.getName());
    }
    static <T extends Animal> T printAndReturnGenericV2(Box<T> box) {
        T t = box.get();
        System.out.println("t.getName() = " + t.getName());
        return t;
    }
     */

    // 와일드 카드 이용
    // wildcard는 제네릭을 좀더 쉽게 쓸 수 있게 도와주는 도구다. wildcard는 만들어진 제네릭을 이용하는 것.
    static void printWildcardV1(Box<?> box) {
        System.out.println("이름 = " + box.get());
    }
    static void printWildcardV2(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
    }
    static Animal printAndReturnWildcardV3(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
        return animal;
    }
}
