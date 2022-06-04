package com.gui;

import java.io.*;
import java.util.TreeMap;

public class AccountsFileManager {
    private static String filePath;

    public static void addAccount(Account acc) throws IOException, ClassNotFoundException {
        File accFile = new File(filePath);
        FileInputStream fis = new FileInputStream(accFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        TreeMap<Integer, Account> accounts = (TreeMap<Integer, Account>) ois.readObject();

        accounts.put(acc.getAccountNumber(), acc);

        FileOutputStream fos = new FileOutputStream(accFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(accounts);
        oos.flush();
        oos.close();
    }

    public static void saveAccount(Account account) throws IOException, ClassNotFoundException {
        File accFile = new File(filePath);
        FileInputStream fis = new FileInputStream(accFile);
        ObjectInputStream ois = new ObjectInputStream(fis);

        TreeMap<Integer, Account> accounts = (TreeMap<Integer, Account>) ois.readObject();
        accounts.replace(account.getAccountNumber(), account);

        FileOutputStream fos = new FileOutputStream(accFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(accounts);
        oos.flush();
        oos.close();
    }

}
