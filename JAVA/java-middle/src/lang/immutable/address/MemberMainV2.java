package lang.immutable.address;

public class MemberMainV2 {

    public static void main(String[] args) {
        ImmutableAddress address = new ImmutableAddress("seoul");

        MemberV2 memberA = new MemberV2("A", address);
        MemberV2 memberB = new MemberV2("B", address);

        // 첫 주소는 둘 다 서울
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        // 회원B의 주소를 부산으로 변경
        memberB.setAddress(new ImmutableAddress("Busan"));
        /*
            memberB의 주소는 바꿀 수 있어야 한다. memberB가 가지고 있는 address 자체가 불변인 거고 B는 불변이면 안된다
            memberB가 불변이면 memberB의 주소를 바꿀 수 없다.
        */
        System.out.println("Busan -> B");
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

    }
}
