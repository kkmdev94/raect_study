package Poly.ex5;

public interface InterfactAnimal {
    void sound(); // public abstract -> 생략 가능

    void move(); // public abstract
    // public을 사용하는 이유는 인터페이스는 보통 여러 군데서 사용하는 목적으로 만들기 때문에 public이 기본값이다.
}
