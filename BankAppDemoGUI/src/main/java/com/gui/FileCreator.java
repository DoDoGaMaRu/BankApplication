package com.gui;

import java.io.*;
import java.util.TreeMap;

public class FileCreator {
    public static void main(String[] args) throws Exception{
        String filePath = "accounts";
        File accFile = new File(filePath);

        FileOutputStream fos = new FileOutputStream(accFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        TreeMap<Integer, Account> abc = new TreeMap<>();

        oos.writeObject(abc);
        oos.flush();
        oos.close();
    }

}
