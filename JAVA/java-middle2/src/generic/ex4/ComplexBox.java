package generic.ex4;

import generic.animal.Animal;

public class ComplexBox<T extends Animal> {
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public <Z> Z printAndReturn(Z z) {
        // 제네릭 타입 (클래스 레벨) 보다 제네릭 메서드가 높은 우선순위를 가지므로, 마지막 이 호출메서드는 제네릭 타입이 아닌
        // 제네릭 메서드가 먼저 적용된다.
        // 모호하면 헷갈린다. 제네릭 타입과 메서드가 이름이 겹치면 둘중 하나를 바꿔주는게 좋다. 그래서 T -> Z로
        System.out.println("aniaml.className = " + animal.getClass());
        System.out.println("t.className  :" + z.getClass().getName());
        return z;
    }
}
