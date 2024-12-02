package scanner.Ex;

import java.util.Scanner;

public class ScannerEx4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("구구단의 단 수를 입력해 주세요(0을 입력하면 종료됩니다.) : ");
            int num = sc.nextInt();

            if( num == 0) {
                System.out.println("0이 입력되어 프로그램을 종료합니다.");
                break;
            }

            System.out.println(num + "단의 구구단 :");
            for(int i = 1; i <= 9; i++ ) {
                System.out.println(num + " X " + i + " = " + num*i  );
            }
        }
    }
}
