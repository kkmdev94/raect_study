package cond.ex;

public class EvenOdEx {

    public static void main(String[] args) {
        int x = 1238122;

        int result = x % 2;

        String cond = (result == 1) ? "홀수" : "짝수";
        System.out.println("출력된 x의 값은 : " + x + ", 유형은 : " + cond);
    }
}
