package enumeration.ref3;

// 열거형도 클래스이기 대문에 당연하게 생성자, 메서드를 만들 수 있다.
public enum Grade {
    BASIC(10), GOLD(20), DIAMOND(30), VIP(50);
    //열거형 변수만 선언하면 상관없지만, 아래의 로직처럼 다른 명령어도 작성해야된다면 ;를 사용해 끊어 줘야도니다.
    // 생성하는것이 다 생략되어 있기 때문에 그냥 열거형변수 옆에 ()를 사용하여 생성자를 호출해주면된다.

    private final int discountPercent;

    Grade(int discountPercent) { // 열거형에서는 생성자에 접근제어자 표시를 하지 않는다. private이 숨어있다고 생각하면 된다.
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    // 추가
    public int discount(int price) {
        return price * discountPercent / 100;
    }
}
