package ref.Ex;

public class ProductOrderMain2 {

    public static void main(String[] args) {
        ProductOrder[] orders = new ProductOrder[3];

        orders[0] = createOrder("apple", 1000, 5);
        orders[1] = createOrder("banana", 1500, 4);
        orders[2] = createOrder("orange", 2000, 6);

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
