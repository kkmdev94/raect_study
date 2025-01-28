package enumeration.ref1;

// 회원 등급을 다루는 '클래스'를 만든다. = ClassGrade가 회원 등급을 다루는 클래스
public class Grade {


    public static final Grade BASIC = new Grade(10);
    public static final Grade GOLD = new Grade(20);
    public static final Grade DIAMOND = new Grade(30);
    public static final Grade VIP = new Grade(50);

    private final int discountPercent;

    public Grade(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
