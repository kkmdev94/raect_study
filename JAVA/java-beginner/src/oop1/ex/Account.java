package oop1.ex;

public class Account {
    int balance = 0;

    int deposit(int amount) {
        balance += amount;
        System.out.println("현재 잔고는 : " + balance);
        return balance;
    }

    int withdraw(int amount) {
        if (balance < amount) {
            System.out.println("잔액이 부족합니다.");
            System.out.println("잔액 : " + balance);
        } else {
            balance -= amount;
            System.out.println("잔액 : " + balance);
        }
        return balance;
    }
}
/*
 int 혹은 void 이런 반환타입을 사용하는것을 헷갈리기에 다시 한번 훑어보자
 */