package array.Ex;

import java.util.Scanner;

public class ArrayEx4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[5];
        int total =0;

        for (int number : numbers) {
            number = sc.nextInt();
            total += number;
        }

        double average = (double) total / numbers.length;

        System.out.println("합계는 : " + total);
        System.out.println("평균은 : " + average);
    }
}
