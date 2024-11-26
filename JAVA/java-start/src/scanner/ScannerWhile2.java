package scanner;

import java.util.Scanner;

public class ScannerWhile2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫 번째 숫자와 두번쨰 숫자 모두 0을 입력하면 프로그램을 종료합니다. ");

        while (true) {
            System.out.print("첫 번째 숫자 : ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자 : ");
            int num2 = sc.nextInt();

            if(num1 == 0 && num2 == 0) {
                System.out.println("두 숫자가 전부 0이 입력되어서 프로그램을 종료합니다.");
                break;
            }
            int sum = num1 + num2;
            System.out.println("두 숫자의 합 : " + sum );
        }
    }
}
