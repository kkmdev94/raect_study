package nested.anonymous.ex;

import java.util.Random;

public class Ex1MainRefV3 {

    public static void hello(Process process) {
        System.out.println("프로그램 시작");
        process.print();
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {

        Process dice = new Process() {

            @Override
            public void print() {
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("주사위 = " + randomValue);
            }
        };

        Process sum = new Process() {

            @Override
            public void print() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("i = " + i);
                }
            }
        };
        hello(dice);
        hello(sum);
    }
}
