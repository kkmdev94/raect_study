package method.Ex;

import java.util.Scanner;

public class MethodEx4Ref {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 10000;

        while (true){
            System.out.println("----------------------------------------------");
            System.out.println("잔고 : 0번 | 입금 : 1번 | 출금 : 2번 | 종료 : 3번");
            System.out.println("----------------------------------------------");
            System.out.print("선택 : ");
            int select = sc.nextInt();

            if (select == 0) {
                System.out.println("현재 잔고는 : " + balance);
            } else if (select == 1) {
                System.out.print("입금할 금액을 입력해주세요 : ");
                int inputAmount = sc.nextInt();
                balance = deposit(balance, inputAmount);
            } else if (select == 2) {
                System.out.print("출금할 금액을 입력해주세요 : ");
                int withAmount = sc.nextInt();
                balance = withdraw(balance, withAmount);
            } else if (select == 3) {
                System.out.println("어플을 종료합니다.");
//                break;
                return;
            } else {
                System.out.println("잘못입력하셨습니다. 다시 확인해주세요.");
            }
//            System.out.println("최종 잔액 : " + balance + "원");
        }

    }

    public static int deposit(int balance, int amount) {
        balance += amount;
        System.out.println(amount + "원을 입금하였습니다.\n 현재 잔액 : " + balance + "원");
        return balance;
    }

    public static int withdraw(int balance, int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원을 출금하였습니다.\n 현재 잔액: " + balance + "원");
        } else {
            System.out.println(amount + "원을 출금하려 했으나 잔액이 부족합니다.");
        }
        return balance;
    }
}
