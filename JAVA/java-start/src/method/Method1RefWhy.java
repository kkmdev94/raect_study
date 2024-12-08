package method;

public class Method1RefWhy {

    public static void main(String[] args) {
        int sum3;
        //계산 1
//        int sum1 = add(5, 10);
//        System.out.println(sum1);
//
//        //계산 2
//        int sum2 = add(15, 20); // 2-2.  즉 main에서 출력이나 그 값을 이용할 수 없다? 이게 맞을까? -> 해당 메소드가 실행이 된것만 확인이 가능하고
//        System.out.println(sum2);

//        sum3 = add(45, 20); // 2-3 아래처럼 void 형태는 반환을 할 수없어 해당 add 매소드의 값을 이용 할 수 없다. 그럼 이거는 어떨때 사용하게 될까??
//        System.out.println(sum3);

        add(100, 200); // 반환 값을 무시를 할 수 도 있다.단순히 메서드 호출만해도 가능 단, void의 경우에는 받으면 안된다.
    }

    //add 메서드
    public static void add(int a, int b) { // 2-1 반환이 int가 아닌 void일 경우 / 2-2번 주석으로 설명을 이어서
//        System.out.println(a + " + " + b + " 연산 수행");
        System.out.println(a + b );
        int sum = a + b;
//        return sum;
    }
}
