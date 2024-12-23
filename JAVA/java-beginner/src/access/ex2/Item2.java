package access.ex2;

import java.util.Scanner;

// 다시 한번 혼자 풀어보는 복습
public class Item2 {
    private String name;
    private int price;
    private int quantity;

    //생성자가 있어야 한다.

    public Item2(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int totalPrice() {
        return price * quantity;
    }
//    기능구현을 해보려 했으나 생각을 해보니 전체 합계는 private으로 접근할 수 없게 해야되는데 item에서 구현해 버리면 해당 로직에 접근을 못해 출력을 할 수 없다.
//    그렇다고 public으로 해버리면 어디에서나 접근이 가능하기에 캡슐화가 깨진다.
//    private int totalSum() {
//        return
//    }
}