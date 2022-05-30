package com.gui;

import java.io.*;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "users";
        File accFile = new File(filePath);

        FileOutputStream fos = new FileOutputStream(accFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        TreeMap<Integer, User> abc = new TreeMap<>();
        oos.writeObject(abc);
        oos.flush();
        oos.close();

/*
        FileInputStream fio = new FileInputStream(accFile);
        ObjectInputStream ois = new ObjectInputStream(fio);
        ois.readObject();
        User acc = (User)ois.readObject();

        acc.setName("백대환");

        System.out.print(acc.getName());
*/
    }

    public static void writeFile(File accFile) throws IOException {
        FileOutputStream fio = new FileOutputStream(accFile);

        fio.flush();
        fio.close();
    }

    public static User readFile(File accFile) throws IOException, ClassNotFoundException {
        FileInputStream fio = new FileInputStream(accFile);
        ObjectInputStream ois = new ObjectInputStream(fio);

        return (User)ois.readObject();
    }
}