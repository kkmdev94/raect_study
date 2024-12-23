package access.ex2;

import java.util.Scanner;

public class ShoppingCartMain2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart2 cart = new ShoppingCart2();

        //기본 생성자로 Item2를 불러서 루프를 돌릴 수 있을지 내일 테스트 해보자.
        Item2 item1 = new Item2(sc.nextLine(), sc.nextInt(), sc.nextInt());
        sc.nextLine();
        Item2 item2 = new Item2(sc.nextLine(), sc.nextInt(), sc.nextInt());


        cart.addItem(item1);
        cart.addItem(item2);

        cart.displayItems();
    }
}
