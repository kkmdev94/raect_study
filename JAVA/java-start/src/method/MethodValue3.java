package method;

public class MethodValue3 {

    public static void main(String[] args) { //main도 메서드이다.
        int num1 = 5;
        System.out.println("1. changeNumber 호출 전, num1 : " + num1); //5
        num1 = changeNumber(num1); // 반환 받은 값을 새로 대입을 해주면 그 값을 사용 할 수 있다.
        System.out.println("4. changeNumber 호출 후. num1 : " + num1); //5 ->
    }

    public static int changeNumber(int num2) { // void로 하면 메서드의 반환값이 반환이 안되니 해당 값을 계산해서 넘겨주고
        num2 = num2 * 2;
        return num2;
    }
}

// 자바의 대원칙
// - 자바는 항상 변수의 값을 복사해서 대입한다 -