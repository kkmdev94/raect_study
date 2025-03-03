package collection.list;

public class BatchProcessor {

    // ArrayList는 O(n) / LinkedList는 O(1) : 앞에 추가한다는 가정하에
//    private final MyArrayList<Integer> list = new MyArrayList<>();
//    private final MyLinkedList<Integer> list = new MyLinkedList<>();
    /*
        BatchProcessor에서는 구체적인 MyArrayList나 아니면 MyLinkedList를 사용하고 있다 이럴 경우 BatchProcessor가 구체적인 클래스에 의존한다고 표현한다.
        즉 리스트를 변경할 때 마다 의존하는 BatchProcessor에서 코드로직을 변경해주어야 한다는 뜻이다.
        하지만 아래의 Array와 Linked의 부모인 MyList를 선언 후 외부에서 입력받는식으로 하면 BatchProcessor에서 코드가 변경될 일은 없다.
        이렇게 의존관계를 주입하여 추성화와 다형성을 모두 챙기면서 객체 지향적으로 코드를 만들 수 있다.
     */
    private final MyList<Integer> list;

    public BatchProcessor(MyList<Integer> list) {
        this.list = list;
    }

    public void logic(int size) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(0, i); // 앞에 추가
        }
        long endTime = System.currentTimeMillis();
        System.out.println("크기 : " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
    }
    /*
    현재 이 로직에서는 MyList list의 구현체를 어떤것을 선택할 지는 실행 시점(런타임)에서 생성자를 통해 결정한다.
    생성자를 통해 MyList 구현체가 전달되고 이 구현체는 MyArrayList의 인스턴스가, MyLinkedList의 인스턴스가 들어올 수도 있다.
    이유는 BatchProcessor의 외부에서 의존관계가 결정되어서 BatchProcessor 인스턴스에 들어오는 것 같다. 이것을 마치 의존 관계가 외부에서 주입되는것 같다고 해서
    이것을 의존관계 주입(dependency injection)이라고 한다.
    참고로 생성자를 통해서 주입하였기에 생성자 의존관계 주입이라고 한다.
     */
}
