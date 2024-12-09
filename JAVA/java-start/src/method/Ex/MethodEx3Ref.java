package method.Ex;

public class MethodEx3Ref {

    public static void main(String[] args) {
        int balance = 10000;

        balance = deposit(balance, 2000);
        balance = withdraw(balance, 15000);
        System.out.println("최종 잔액 : " + balance + "원");
        // 출금 200
//        int withdrawAmount = 2000;
//        if (balance >= withdrawAmount) {
//            balance -= withdrawAmount;
//            System.out.println(withdrawAmount + "원을 출금하였습니다. 현재 잔액: " + balance + "원");
//        } else {
//            System.out.println(withdrawAmount + "원을 출금하려 했으나 잔액이 부족합니다.");
//        }
//        System.out.println("최종 잔액 : " + balance + "원");


    }

    public static int deposit(int balance, int amount) {
        balance += amount;
        System.out.println(amount + "원을 입금하였습니다. 현재 잔액 : " + balance + "원");
        return balance;
    }

    public static int withdraw(int balance, int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원을 출금하였습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println(amount + "원을 출금하려 했으나 잔액이 부족합니다.");
        }
        return balance;
    }
}
