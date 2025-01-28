package enumeration.ref1;

public class DiscountService {

    public int discount(Grade classGrade, int price) {
        return price * classGrade.getDiscountPercent() / 100;
    }
}
