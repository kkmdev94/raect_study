package lang.immutable.address;

public class RefMain1_2 {

    public static void main(String[] args) {
        // 참조형 변수는 하나의 인스턴스를 공유 할 수 있다.
        Address a = new Address("Seoul");
        Address b = new Address("Seoul");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        b.setValue("busan");
        System.out.println("busan -> b");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
