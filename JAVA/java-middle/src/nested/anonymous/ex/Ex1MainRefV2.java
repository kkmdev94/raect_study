package nested.anonymous.ex;

import java.util.Random;

public class Ex1MainRefV2 {

    public static void hello(Process process) {
        System.out.println("프로그램 시작");
        process.print();
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        class Dice implements Process {

            @Override
            public void print() {
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("주사위 = " + randomValue);
            }
        }

        class Sum implements Process {

            @Override
            public void print() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("i = " + i);
                }
            }
        }
        hello(new Dice());
        hello(new Sum());
    }
}
