package loop.ex;

import java.util.Scanner;

public class ScannerWhileEx2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        while (true){
            System.out.print("상품의 가격을 입력하세요 (-1을 입력하면 종료) : ");
            int price = sc.nextInt();

            if(price == -1 ){
                System.out.println("-1이 입력되서 프로그램을 종료합니다.");
                break;
            }

            System.out.print("구매하려는 수량을 입력하세요 : ");
            int quantity = sc.nextInt();

            int totalprice = price * quantity;

            sum += totalprice;

            System.out.println("총 비용 : " + sum);
        }
    }
}
