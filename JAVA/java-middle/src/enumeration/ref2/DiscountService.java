package enumeration.ref2;

public class DiscountService {

    public int discount(Grade grade, int price) {
        //inline Variable = 변수를 하나로 합친다 / ctrl + alt + N
        return price * grade.getDiscountPercent() / 100;
    }
}
