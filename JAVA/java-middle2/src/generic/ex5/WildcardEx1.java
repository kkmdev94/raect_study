package generic.ex5;

public class WildcardEx1 {

    // 제네릭 메서드를 이용해서 작업을 진행했지만 이렇게 제네릭 메서드를 쓰지 않고 족므더 간단히 사용하는 방법
    static <T> void printGenericV1(Box<T> box) {
        System.out.println("T = " + box.get());
    }

    // 와일드 카드 이용
    // wildcard는 제네릭을 좀더 쉽게 쓸 수 있게 도와주는 도구다. wildcard는 만들어진 제네릭을 이용하는 것. 와일드 카드는 일반 메서드이다.
    // ? 를 사용하면 어떠한 타입이건 다 받을 수 있다. 즉, Object라는 뜻이고 이러한 제한이 없는 와일드 카드를 비제한 와일드카드라고 한다.
    static void printWildcardV1(Box<?> box) {
        System.out.println("이름 = " + box.get());
    }
}
