package class2.Ex;

import java.util.Scanner;

public class ProductOrderMain3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력할 주문의 갯수를 입력하세요 : ");
        int quantitySc = sc.nextInt();
        ProductOrder[] orders = new ProductOrder[quantitySc];


        for (int i = 0; i < orders.length; i++) {
            sc.nextLine();
            System.out.println((i+1) + "번째 주문 정보를 입력하세요.");

            System.out.print("상품명 : ");
            String name = sc.nextLine();

            System.out.print("가격 : ");
            int price = sc.nextInt();

            System.out.print("수량 : ");
            int quantity = sc.nextInt();

            orders[i] = createOrder(name,price,quantity);
        }
        printOrders(orders);

        int totalAmount = getTotalAmount(orders);
        System.out.println("최종 합계는 : " + totalAmount + "원");
    }

    public static ProductOrder createOrder(String name, int price, int quantity) {
        ProductOrder order = new ProductOrder();
        order.productName = name;
        order.price = price;
        order.quantity = quantity;
        return order;
    }

    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder f : orders) {
            System.out.println("이름 : " + f.productName + " 가격 : " + f.price + " 갯수 : " + f.quantity);
        }

    }

    static int getTotalAmount(ProductOrder[] orders) {
        int total = 0;
        for (ProductOrder f : orders) {
            total += f.price * f.quantity;
        }
        return total;
    }
}
