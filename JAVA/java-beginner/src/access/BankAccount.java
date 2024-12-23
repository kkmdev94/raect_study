package access;

public class BankAccount {

    private int balance;

    public BankAccount() { // 생성자 자동 생성 alt + insert
        balance = 0;
    }

    //public 메서드 : deposit
    public void deposit(int amount) {
        if (isAmountValid(amount)) {
            balance += amount;
        } else {
            System.out.println("No");
        }
    }

    // public 메서드 : withdraw
    public void withdraw(int amount) {
        if (isAmountValid(amount) && balance - amount >= 0) {
            balance -= amount;
        } else {
            System.out.println("NONONO");
        }
    }

    public int getBalance() {
        return balance;
    }

    private boolean isAmountValid(int amount) {
        //금액이 0보다 커야함
        return amount > 0;
    }

}
