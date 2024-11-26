package scanner;

import java.util.Scanner;

public class ScannerWhile3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        while (true) {
            System.out.print("숫자를 입력해 주세요(0이 입력되면 프로그램은 종료됩니다.) : ");
            int num = sc.nextInt();
            if (num == 0 ){
                System.out.println("0이 입력되어 프로그램을 종료합니다.");
                break;
            }
//            sum = sum + num;
            sum += num;
        }
        System.out.println("입력값의 총 합은 : " + sum);
    }
}
