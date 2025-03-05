package collection.list.test.ex2;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Item> arrayList = new ArrayList<>();

    public void addItem(Item item) {
        arrayList.add(item);
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        for (int i = 0; i < arrayList.size(); i++) {
            Item item =  arrayList.get(i);
            System.out.println("상품명 : " + item.getName() + ", 합계 : " + item.getTotalPrice());
        }
        System.out.println("전체 합계 합 : " + totalPrice());
    }

    private int totalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            Item item =  arrayList.get(i);
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}
