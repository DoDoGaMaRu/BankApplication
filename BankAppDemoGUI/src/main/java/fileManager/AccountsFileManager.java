package fileManager;

import account.Account;

import java.io.*;
import java.util.TreeMap;

public class AccountsFileManager {
    private final static String filePath = "accounts";

    public static void addAccount(Account acc) throws IOException, ClassNotFoundException {
        File accFile = new File(filePath);
        TreeMap<Integer, Account> accounts = getTreeMap(accFile);

        accounts.put(acc.getAccountNumber(), acc);
        writeFile(accFile, accounts);
    }

    public static Account findAccount(int accNum) throws IOException, ClassNotFoundException {
        File accFile = new File(filePath);
        return (Account) getTreeMap(accFile).get(accNum);
    }

    public static void saveAccount(Account acc) throws IOException, ClassNotFoundException {
        File accFile = new File(filePath);
        TreeMap<Integer, Account> accounts = getTreeMap(accFile);

        accounts.replace(acc.getAccountNumber(), acc);
        writeFile(accFile, accounts);
    }



    private static TreeMap<Integer, Account> getTreeMap(File accFile) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(accFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        TreeMap<Integer, Account> accounts = (TreeMap<Integer, Account>) ois.readObject();

        Account.setStaticAccNum(accounts.size());
        return accounts;
    }

    private static void writeFile(File accFile, TreeMap<Integer, Account> accounts) throws IOException {
        FileOutputStream fos = new FileOutputStream(accFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(accounts);
        oos.flush();
        oos.close();
    }
}
