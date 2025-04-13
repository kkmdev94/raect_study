package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV2 implements BankAccount {

    private int balance;

    public BankAccountV2(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public synchronized boolean withdraw(int aomount) { // synchronized =  동기화 /  즉, 절대 동시에 실행되 지 않는다. 한번의 하나의 스레드만 실행된다.
        log("거래 시작 : " + getClass().getSimpleName());

        log("[검증 시작] 출금액 : " + aomount + ", 잔액 : " + balance);
        if (balance < aomount) {
            log("[검증 실패]");
            return false;
        }

        log("[검증 완료] 출금액 : " + aomount + ", 잔액 : " + balance);
        sleep(1000); // 출금에 걸리는 시간으로 가정
        balance = balance - aomount;
        log("[출금 완료] 출금액 : " + aomount + ", 잔액 : " + balance);

        log("거래 종료 : ");
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
