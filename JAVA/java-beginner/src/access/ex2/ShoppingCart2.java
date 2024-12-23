package access.ex2;

import java.util.Scanner;

public class ShoppingCart2 {
    private Item2[] items = new Item2[10];
    private int itemCount;

    public void addItem(Item2 item) {
        if (itemCount >= items.length) {
            System.out.println("장바구니 최대 갯수를 넘을 수 없습니다.");
        }
        items[itemCount] = item;
        itemCount++;
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        for (int i = 0; i < itemCount; i++) {
            Item2 item = items[i];
            System.out.println("상품명 : " + item.getName() +", 합계 : " + item.totalPrice());
        }
        System.out.println("전체 총 합계는 : " + totalPrice());
    }

    public int totalPrice() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            Item2 item = items[i];
            total += item.totalPrice();
        }
        return total;
    }
}
