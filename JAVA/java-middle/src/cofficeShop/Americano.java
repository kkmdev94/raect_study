package cofficeShop;

public class Americano implements Coffie {

    private String menu = "아메리카노";

    @Override
    public void coffie() {
        System.out.println("메뉴 : " + menu);
    }

    @Override
    public void made() {
        System.out.println("아메리카노를 만듭니다.");
    }

    @Override
    public void take() {
        System.out.println("주문하신 아메리카노 나왓습니다.");
    }
}
