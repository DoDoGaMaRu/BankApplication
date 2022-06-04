package com.gui;

public interface IAccount {
    public int getAccountNumber();

    public int getBalance();

    public void deposit(int amount);

    public void withdraw(int amount);

    public void transfer(int accNum, int amount);

    public boolean validatePIN(int pin);

    public String toString();
}
