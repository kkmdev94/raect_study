package access.ex;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;

    public void addItem(Item item) {
//        for (int i = 0; i < items.length; i++) {
//            if (i <= items.length) {
//                items[i] = item;
//            } else {
//                System.out.println("장바구니가 가득 찼습니다.");
//                return;
//            }
//            itemCount++;
//        }
        if (itemCount >= items.length) {
            System.out.println("장바구니가 가득 찼습니다.");
            return;
        }

        items[itemCount] = item;
        itemCount++;
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            System.out.println("상품명 : " + item.getName() + "가격 : " + item.getTotal());
        }
        System.out.println("전체 합계 값 : " + sum());
    }

    private int sum() {
        int totalaprice = 0;
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            totalaprice += item.getTotal();
        }
        return totalaprice;
    }
}
