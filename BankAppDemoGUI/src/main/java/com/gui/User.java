package com.gui;

import java.util.ArrayList;

public class User {
    private String name;
    private String id;
    private String pwd;
    private ArrayList<Account> accounts;

    public User(String name, String id, String pwd) {
        this.name = name;
        this.id = id;
        this.pwd = pwd;
        accounts = new ArrayList<>();
        accounts.add(new Account(11,5000));
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public void addAccount(Account newAccount) {
        accounts.add(newAccount);
    }
}
