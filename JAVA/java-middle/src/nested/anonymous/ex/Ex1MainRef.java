package nested.anonymous.ex;

import java.util.Random;

public class Ex1MainRef {


        int randomValue = new Random().nextInt(6) + 1;
        System.out.println("주사위 = " + randomValue);

        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
        }
    Process process = new Process(){

        @Override
        public void print() {
            System.out.println("프로그램 시작");
            System.out.println("프로그램 종료");
        }
    };

    public static void main(String[] args) {
    }
}
