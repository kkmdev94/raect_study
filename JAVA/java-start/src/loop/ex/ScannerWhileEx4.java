package loop.ex;

import java.util.Scanner;

public class ScannerWhileEx4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int price;
        int qunitity;
        int option = 0;

        while (true) {
            System.out.println("1 : 상품 입력, 2 : 결제, 3: 프로그램 종료");
            option = sc.nextInt();
            
            if(option == 1) {
                System.out.print("상품명을 입력하세요 : " );
                name = sc.nextLine();
                sc.nextLine();
                
                System.out.print("상품의 가격을 입력하세요 : ");
                price=sc.nextInt();
                
                System.out.print("구매 수량을 입력하세요 : ");
                qunitity = sc.nextInt();
                
                int sum = price * qunitity;
                
                System.out.println("상품명 : " + name + " 가격 : " + price + " 수량 : " + qunitity + " 합계 : " + sum);
            } else if (option == 2) {
                System.out.println("222");
            }else if (option == 3) {
                break;
            }else{
                System.out.println("number");
            }
        }
    }
}
