package account;

import java.io.Serializable;

public class Account implements IAccount, Serializable {
    private static int staticAccNum = 0;

    private int accountNumber;
    private int pin;
    private int balance;

    public Account(int pin, int amount) {
        accountNumber = ++staticAccNum;
        this.pin = pin;
        balance = amount;
    }

    public static void setStaticAccNum(int accNum) { staticAccNum = accNum; }


    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    @Override
    public void withdraw(int amount) throws Exception {
        if (amount > balance) {
            throw new Exception();
        }
        balance -= amount;
    }

    @Override
    public void transfer(int accNum, int amount) {
        balance -= amount;
    }

    @Override
    public boolean validatePIN(int pin) {
        return (pin == this.pin) ? true : false;
    }

    @Override
    public String toString() {
        return String.format("계좌번호 : %d\t잔액 : %d₩", accountNumber, balance);
    }
}
