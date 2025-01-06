package lang.immutable.address;

public class RefMain2 {

    public static void main(String[] args) {
        // 참조형 변수는 하나의 인스턴스를 공유 할 수 있다.
        ImmutableAddress a = new ImmutableAddress("Seoul");
        ImmutableAddress b = a; // 참조값 대입을 막을 수 있는 방법이 없다.
        System.out.println("a = " + a);
        System.out.println("b = " + b);

//        b.setValue("busan");
        b = new ImmutableAddress("busan"); // 새로운 객체를 생성 후 대입
        System.out.println("busan -> b");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
