package generic.ex1;

public class GenericText {
    /*
        1. 제네릭(Generic) 단어
            - 제네릭이라는 단어는 일반적인, 범용적인이라는 영단어이다.
            - 특정 타입에 속한 것이 아닌 일반적으로, 범용적으로 사용할 수 있다는 뜻
        2. 제네릭 타입(Generic Type)
            - 클랫스나 인터페이스 정의시 매개변수를 사용
            - 제네릭 클래스, 제네릭 인터페이스를 모두 합쳐 제네렉 타입이라함.
        3. 타입 매개변수(Type Parameter)
            - 제네릭 타입 or 메서드에서 사용되는 변수, 실제 타입으로 대체됨
            - ex: GenericBox<T> 여기서 T를 타입 매개변수라 한다.
        4. 타입 인자(Type Argument)
            - 제네릭 타입을 사용할 때 제공되는 실제 타입
            - ex: GenerciBox<Integer> 여기서 Integer를 타입 인자라고 한다

        타입 매개변수 같은경우 아무거나 들어가도 문제가 없지만 관례가 있어서 따라서하는게 좋다.

        E - Elementt
        K - Key
        N - Number
        T - Type
        V - Value
        S,U,V etc. - 2nd, 3rd, 4th types

        타입 인자로 기본형은 사용할 수 없다.
            - 제네릭 타입은 기본형을 사용할 수 없다. 대신 래퍼 클래스를 사용하면 된다.

        로 타입(row Type)
        제네릭 타입 사용시 항상 <>를 사용하여 원하는 타입을 사용해야 하지만
        <>를 지정하지 않을 수 있는데, 이것을 로 타입(row type), 또는 원시 타입이라고 한다.
     */
}
