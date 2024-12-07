package array.Ex;

import java.util.Scanner;

public class ArrayEx5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 0;

        System.out.print("입력 받을 숫자의 개수를 입력하세요 : " );
        int num = sc.nextInt();

        int[] numbers = new int[num];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
            total += numbers[i];
        }

        double average = (double) total / numbers.length;

        System.out.println("입력한 정수의 합계 : " + total);
        System.out.println("입력한 정수의 평균 : " + average);
    }
}
