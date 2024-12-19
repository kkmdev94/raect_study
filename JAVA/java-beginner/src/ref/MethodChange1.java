package ref;

public class MethodChange1 {

    public static void main(String[] args) {
        int a =10;
        System.out.println("메서드 호출 전: a = " + a); // 10
        changePrimitive(a); // ()안에는 x의값인 20이 들어가 있다. 하지만 호출을 하면서 파라미터의 값으로 a를 호출했기에 x에는 a가 복사되어 들어가있다.
        System.out.println("메서드 호출 후: a = " + a); // 10
    }

    public static void changePrimitive(int x) {
        x = 20;
    }
    /* 어떤게 맞을까
        changePrimitive(x) x =20
        호출을 하면서 changePrimitive(20)
        x = a가 되버리면서 x = 10 되어 버린 것 일까?

        호출된 메서드의 매계변수 x에 a의 값을 전달하는 것이다.
        즉 이건 int x = a라고 볼 수 있다.
    */
}
