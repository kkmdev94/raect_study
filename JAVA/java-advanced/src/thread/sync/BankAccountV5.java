package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV5 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV5(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int aomount) {
        log("거래 시작 : " + getClass().getSimpleName());

        if (!lock.tryLock()) { // lock을 얻으면 진행 / lock을 획득 하지 못하면 바로 false를 반환하고 종료.
            log("[진입 실패] 이미 처리중인 작업이 있습니다.");
            return false;
        }

        // ==임계 영역 시작
        try {
            log("[검증 시작] 출금액 : " + aomount + ", 잔액 : " + balance);
            if (balance < aomount) {
                log("[검증 실패]");
                return false;
            }

            log("[검증 완료] 출금액 : " + aomount + ", 잔액 : " + balance);
            sleep(1000); // 출금에 걸리는 시간으로 가정
            balance = balance - aomount;
            log("[출금 완료] 출금액 : " + aomount + ", 잔액 : " + balance);
            // ==임계 영역 종료==
        } finally { // lock을 사용하면 try-finally를 사용해서 무조건 풀어줘야 한다.
            lock.unlock(); // 반듯이 언락을 걸어야댐.
        }

        log("거래 종료 : ");
        return true;
    }

    @Override
    public int getBalance() {
        try {
            lock.lock();
            return balance;
        }finally {
            lock.unlock();
        }
    }
}
