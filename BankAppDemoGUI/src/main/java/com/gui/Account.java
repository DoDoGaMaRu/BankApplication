package com.gui;

public class Account {
    private static int staticAccNum;
    private int accountNumber;
    private int pin;
    private int balance;

    public Account(int pin, int amount) {
        accountNumber = ++staticAccNum;
        this.pin = pin;
        balance = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public boolean validatePIN(int pin) {
        return (pin == this.pin) ? true : false;
    }

    public String toString() {
        return String.format("계좌번호 : %d\t잔액 : %d₩", accountNumber, balance);
    }
}
