package final1;

public class ConstructInit {

    final int value; // 초기값 지정 x
    //final을 이 필드(멤버 변수)에 사용할 경우에는 생성자를 통해서 한번 이렇게 초기화를 할 수가 있다.

    public ConstructInit(int value) {
        this.value = value; //생성자를 통해서 값을 할당하게 된다. 이후에는 이 값을 바꾸는게 불가능하다.
    }
}
