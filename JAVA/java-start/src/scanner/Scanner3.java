package scanner;

import java.util.Scanner;

public class Scanner3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("값을 입력해 주세요 : ");
        int num1 = sc.nextInt();

        System.out.print("값을 입력해 주세요 : ");
        int num2 = sc.nextInt();

        if(num1 > num2 ) {
            System.out.println(num1 + " 이 " + num2 + "보다 크다");
        } else if (num1 < num2) {
            System.out.println(num2 + " 이 " + num1 + "보다 크다");
        }else {
            System.out.println(num1 + " 과 " + num2+ " 은 같다");
        }
    }
}
