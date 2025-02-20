package generic.ex1;

public class GenericBox<T> { // 굳이 T가 아니여도 된다 아무 단어를 넣어도 가능 / <> 이런 다이아 몬드를 사용한 클래스를 제네릭 클래스라고 한다.
    // T를 타입 매개변수라 하는데, 이 타입 매개변수는 이후에 Integer, String으로 변할 수 있다.

    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
