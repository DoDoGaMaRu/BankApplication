package com.gui;

public class User {
    private String name;
    private int id;
    private int pwd;
    private Account account;

    public User (String name) {
        this.name = name;
        this.account = new Account(11,5000);
    }

    public String getName() {
        return name;
    }

    public Account getAccount(){
        return account;
    }
}
