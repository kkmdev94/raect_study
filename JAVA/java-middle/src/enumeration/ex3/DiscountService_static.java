
package enumeration.ex3;

import static enumeration.ex3.Grade.*;

public class DiscountService_static {

    public int discount(Grade grade, int price) {
        int discountPercent = 0;

        if (grade == BASIC) {
        // 상수는 클래스에 붙어서 사용이 가능하여 static을 import하면 Grade.BASIC에서 .의 앞을 생략 가능하다.
            discountPercent = 10;
        } else if (grade == GOLD) {
            discountPercent = 20;
        } else if (grade == DIAMOND) {
            discountPercent = 30;
        } else if (grade == VIP) {
            discountPercent = 50;
        } else {
            System.out.println("할인X");
        }
        return price * discountPercent / 100;
    }
}
