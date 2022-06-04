package com.gui;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Comparable<User>, Serializable {
    private String name;
    private String id;
    private String pwd;
    private ArrayList<Integer> accounts;

    public User(String name, String id, String pwd) {
        this.name = name;
        this.id = id;
        this.pwd = pwd;
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


    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void addAccounts(int accNum) {
        accounts.add(accNum);
    }

    public ArrayList<Integer> getAccounts() {
        return accounts;
    }

    @Override
    public int compareTo(User o) {
        return id.compareTo(o.id);
    }
}
