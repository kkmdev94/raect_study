package cond.ex;

public class If3 {

    public static void main(String[] args) {
        int dollar = -3;

        if (dollar > 0) {
            System.out.println("change money is = " + (dollar * 1300) + "won");
        } else if (dollar == 0) {
            System.out.println("not change money");
        } else {
            System.out.println("not money");
        }
    }
}
