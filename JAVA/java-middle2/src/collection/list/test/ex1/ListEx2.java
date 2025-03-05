package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while (true) {
            int num = sc.nextInt();
            if (num == 0) {
                System.out.println("0을 입력하셨으므로 프로그램을 종료합니다.");
                break;
            }
            integers.add(num);
        }
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i));
            if (i < integers.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
