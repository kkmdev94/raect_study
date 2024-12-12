package class1.Ex;

public class ProductOrderMain {

    public static void main(String[] args) {
        ProductOrder apple = new ProductOrder();
        apple.productName = "apple";
        apple.price = 1000;
        apple.quantity = 5;

        ProductOrder banana = new ProductOrder();
        banana.productName = "banana";
        banana.price = 1500;
        banana.quantity = 4;

        ProductOrder orange = new ProductOrder();
        orange.productName = "orange";
        orange.price = 2000;
        orange.quantity = 6;

        ProductOrder[] pr = {apple,banana,orange};
        int total = 0;

        for (ProductOrder f : pr) {
            System.out.println("이름 : " + f.productName + " 가격 : " + f.price + " 갯수 : " + f.quantity);
            int sum = f.price * f.quantity;
            total += sum;
        }
        System.out.println("최종 합계는 : " + total + "원");
    }
}
