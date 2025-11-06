package hellojpa;

public class ValueMain {

    public static void main(String[] args) {
        int a = 10;
        int b = 10;

        System.out.println("a == b :" + (a == b));

        Address address1 = new Address("city", "street", "10000");
        Address address2 = new Address("city", "street", "10000");

        System.out.println("ad1 == ad2 : " + (address1 == address2));
        System.out.println("bb1 == bb2 : " + (address1.equals(address2))); // equals 오버라이드 구현 필수!
    }
}
