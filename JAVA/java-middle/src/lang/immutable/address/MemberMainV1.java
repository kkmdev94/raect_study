package lang.immutable.address;

public class MemberMainV1 {

    public static void main(String[] args) {
        Address address = new Address("seoul");

        MemberV1 memberA = new MemberV1("A", address);
        MemberV1 memberB = new MemberV1("B", address);

        // 첫 주소는 둘 다 서울
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        // 회원B의 주소를 부산으로 변경
//        Address address1 = memberB.getAddress();
//        address1.setValue("Busan");

        memberB.getAddress().setValue("Busan");
        System.out.println("Busan -> memberB.address");
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }
}
