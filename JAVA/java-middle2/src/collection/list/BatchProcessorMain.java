package collection.list;

public class BatchProcessorMain {
    /*
    선생님의 강의를 들으면서 항상 하셨던 것 : 재사용성을 높이려면 나중으로 미뤄야한다.
    그 예시로 메서드에서 매개변수를 넣은 이유는 그 매개변수를 넣음으로서 매개변수에서 값을 나중에 넘겨줄 수 있고, 제네릭 같은 경우도
    사용하는 타입을 나중으로 미뤄서 재사용성이 높아진다. 이번 예시도 그렇다. 구체적인 타입을 정하는게 아닌 구체적은 클래스 인스턴스를 나중으로 미룸으로써 재사용성이 높아진 것이다.
     */

    public static void main(String[] args) {
//        MyArrayList<Integer> list = new MyArrayList<>();
        MyLinkedList<Integer> list = new MyLinkedList<>();

        BatchProcessor processor = new BatchProcessor(list);
        processor.logic(100_000);
    }
}
/*
MyList 인터페이스 도입으로 같은 리스트 자료구조를 그대로 사용하면서 원하는 구현 방식으로 변경이 가능해지며,
BatchProcessor에서는 추상적인 MyList에 읜존하여 런타임에 MyList의 구현체를 얼마든지 선택 할 수 있다
의존관계를 미리 결정하는것이 아닌 런타임에 객체를 생성하는 시점으로 미뤄둔다. 따라서 런타임에 MyList의 구현체를 변경해도 BatchProcessor의 코드는 전혀 변경하지 않아도 된다.
이렇게 생성자를 통해 런타임 의존관계를 주입하는것을 생성자 의존관계 주입, 생성자 주입이라고 한다.
이번 예시를 통해 OCP 원칙을 지켰다. 또한 클라이언트 코드의 변경없이 MyList인터페이스의 구현을 자유롭게 확장이 가능하다.

클라이언트 클래스는 컴파일 타임에 추상적인 것에 의존하고, 런타임에 의존관계 주입을 통해 구현체를 주입받아 사용함으로써 이런 이점을 얻을 수 있다.

전략 패턴(Strategy Pattern)
디자인 패턴 중에 가장 중요한 패턴을 하나 뽑으라고 하면 전략 패턴을 뽑을 수 있다. 전략 패턴은 알고리즘을
클라이언트 코드의 변경 없이 쉽게 교체할 수 있다. 방금 설명한 코드가 바로 전략 패턴을 사용한 코드이다.
MyList 인터페이스가 바로 전략을 정의하는 인터페이스가 되고, 각각의 구현체인 MyArrayList,MyLinkedList가 전략의 구체적인 구현이 된다.
그리고 전략을 클라이언트 코드(BatchProcessor)의 변경 없이 손쉽게 교체할 수 있다
 */
