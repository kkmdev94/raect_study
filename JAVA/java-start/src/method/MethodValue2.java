package method;

public class MethodValue2 {

    public static void main(String[] args) { //main도 메서드이다.
        int number = 5;
        System.out.println("1. changeNumber 호출 전, num1 : " + number); //5
        changeNumber(number);
//        System.out.println("4. changeNumber 호출 후. num1 : " + (number+number)); //5 ->
        System.out.println("4. changeNumber 호출 후. num1 : " + number); //5 ->
    }
    // 각각의 메서드 안에서 사용하는 변수는 서로 완전히 분리된 다른 변수이다. 즉, changeNumber에서 사용된 number와 main에서 사용된 number는 서로 완전히 다른 변수이다.
    // changeNumber 메소드를 호출해서 number값을 가져갈 때 number 자체를 가져간 것이 아닌 5의 값만 복사해서 가져간 것이고, changeNumber 메서드에서 더하고 빼고 해도
    // 결국 main과 changeNumber에서의 number는 서로 다른 number라 4번 출력문에서 number의 값이 10아닌 5가 출력된 것이다.
    // 이해하기 쉽게 설명하자면 main에 있는 number는 서울number이고 changeNUmber에 있는 number는 부산에 있는 number이다.
    // 이것도 결국 자바의 대원칙인 변수의 값을 복사해서 대입한다와 일치한다.

    public static void changeNumber(int number) {
        System.out.println("2. changeNumber 변경 전, num2 : " + number); //5
        number = number  * 2; //10
        System.out.println("3. changeNumber 변경 후, num2 : " + number); //10 -> 그럼 여기서는 왜 바뀌엇는가... 그것은 위에서
    }
}
// 자바의 대원칙
// - 자바는 항상 변수의 값을 복사해서 대입한다 -