package scanner.Ex;

import java.util.Scanner;

public class ScannerEx2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("하나의 정수를 입력하세요 : ");
//        int num = sc.nextInt();
//
//        if (num % 2 == 1) {
//                System.out.println("입력한 숫자 " + num + "은 홀수입니다.");
//        }else {
//                System.out.println("입력한 숫자 " + num + "은 짝수입니다.");
//        }
        int num = sc.nextInt();
        String  avg = (num % 2 == 0) ? "짝수입니다":"홀수입니다.";
        System.out.println(avg);

    }
}
