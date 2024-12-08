package method;

public class Method1Ref {

    public static void main(String[] args) {
        //계산 1
        int sum1 = add(5, 10);
        System.out.println(sum1);

        //계산 2
        int sum2 = add(15, 20);
        System.out.println(sum2);

//        add(100, 200); // 반환 값을 무시를 할 수 도 있다.단순히 메서드 호출만해도 가능 단, void의 경우에는 받으면 안된다.
    }

    //add 메서드
    public static int add(int a, int b) {
        System.out.println(a + " + " + b + " 연산 수행");
        int sum = a + b;
        return sum;
    }
}
