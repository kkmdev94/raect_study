package final1;

public class FieldInit {

    static final int CONST_VALUE = 10; //static과 final을 같이 쓰면 변하지 않는 공용 변수를 만들 수 있다. / 상수
    final int value = 10; // 초기값을 넣어버린 경우에는 생성자를 통해서 값을 넣을 수 없다.

    // final은 값이 한번 정해지면 끝이다.
    // final과 필드 초기화를 사용하는 경우 static을 붙여서 사용하는게 메모리 적으로 효율이 좋다.
}
