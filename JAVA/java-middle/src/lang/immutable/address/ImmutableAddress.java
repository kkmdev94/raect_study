package lang.immutable.address;

public class ImmutableAddress {
    // final이 핵심이 아니다. 객체 안에 있는 이 상태, 이 값들이 바뀌지 않으면 불변 객체이다.

    private final String value; // 한번 값을 생성했으니 변경 X

    public ImmutableAddress(String value) {
        this.value = value;
    }

    // 생성자로 생성하면 값을 바꾸는 것이 불가능 하니 setValue에서 값을 바꾸는게 불가능.
    // 그래서 setValue는 삭제

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ImmutableAddress{" +
                "value='" + value + '\'' +
                '}';
    }
}
