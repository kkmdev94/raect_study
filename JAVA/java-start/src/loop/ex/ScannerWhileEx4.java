package loop.ex;

import java.util.Scanner;

public class ScannerWhileEx4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;

        while (true) {
            System.out.println("1 : 상품 입력, 2 : 결제, 3: 프로그램 종료");
            int option = sc.nextInt();
            
            if(option == 1) {
                System.out.print("상품명을 입력하세요 : " );
                String name = sc.nextLine();
                sc.nextLine();
                
                System.out.print("상품의 가격을 입력하세요 : ");
                int price=sc.nextInt();
                
                System.out.print("구매 수량을 입력하세요 : ");
                int qunitity = sc.nextInt();
                
                int sum = price * qunitity;
                
                System.out.println("상품명 : " + name + " 가격 : " + price + " 수량 : " + qunitity + " 합계 : " + sum);

                total += sum;
            } else if (option == 2) {
                System.out.println("총 비용 : " + total);
                total = 0;
            }else if (option == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }else{
                System.out.println("올바른 숫자를 입력해 주세요");
            }
        }
    }
}
