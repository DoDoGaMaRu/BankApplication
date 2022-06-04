package com.gui;

import java.io.*;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

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