package com.gui;

import java.io.*;
import java.util.TreeMap;

public class FileCreator {
    public static void main(String[] args) throws Exception{
        String filePath = "users";
        File accFile = new File(filePath);

        FileOutputStream fos = new FileOutputStream(accFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        TreeMap<String, User> abc = new TreeMap<>();

        oos.writeObject(abc);
        oos.flush();
        oos.close();
    }

}
