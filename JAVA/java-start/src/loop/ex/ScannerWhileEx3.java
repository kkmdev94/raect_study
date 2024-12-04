package loop.ex;

import java.util.Scanner;

public class ScannerWhileEx3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        System.out.println("숫자를 입력하세요. 입력을 중단하려면 -1 을 입력하세요 : ");
//        while (true) {
//            int num = sc.nextInt();
//
//            if(num != -1){
//                sum += num;
//                count++;
//            }else { // 조건문의 정의가 -1이 아닐때! 라면 이니까 -1이면! 종료가 되는의미라 -2 -3을 입력해도 종료가 안되지만 -1은 종료가 된다.
//                System.out.println("-1이 입력되어 프로그램을 종료합니다.");
//                System.out.println("입력한 숫자들의 합계 : " + sum);
//                double average = (double) sum / count;
//                System.out.println("입력한 숫자들의 평균 : " + average);
//                break;
//            }
        int num =0;
        while ((num = sc.nextInt()) != -1){
            sum += num;
            count++;
        }
        System.out.println("-1이 입력되어 프로그램을 종료합니다.");
        double average = (double) sum / count;
        System.out.println("sum : " + sum);
        System.out.println("average : " + average);
    }
}
