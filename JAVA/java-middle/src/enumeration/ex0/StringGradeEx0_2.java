package enumeration.ex0;

public class StringGradeEx0_2 {

    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();

        // 존재하지않는 등급
        int vip = discountService.discount("VIP", price);
        System.out.println("VIP 할인 금액 : " + vip);

        // 오타
        int diamond = discountService.discount("DIAMONDD", price);
        System.out.println("DIAMOND 할인 금액 : " + diamond);

        // 소문자 입력
        int gold = discountService.discount("gold", price);
        System.out.println("GOLD 할인 금액 : " + gold);

    }
}
