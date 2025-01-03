package pay.ex0;

import java.util.Scanner;

public class PayMain1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            PayService payService = new PayService();

            while (true) {
                System.out.print("결제 수단을 입력하세요 : ");
                String payOption = sc.nextLine();
                if (payOption.equals("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.print("결제 금액을 입력하세요 : ");
                    int amount1 = sc.nextInt();
                    payService.processPay(payOption, amount1);
                }
                sc.nextLine();
            }
        }
}
