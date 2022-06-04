package com.gui;

public class MinusAccount extends Account {

    private int creditLimit;

    public MinusAccount(int pin, int amount, int creditLimit) {
        super(pin, amount);
        this.creditLimit = creditLimit;
    }
}
