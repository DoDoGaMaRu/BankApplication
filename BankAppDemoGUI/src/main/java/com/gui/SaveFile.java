package com.gui;

import java.io.*;
import java.util.TreeMap;

public class SaveFile {
    public static void saveUser(User user) throws IOException, ClassNotFoundException {
        String filePath = "users";
        File accFile = new File(filePath);
        FileInputStream fis = new FileInputStream(accFile);
        ObjectInputStream ois = new ObjectInputStream(fis);

        TreeMap<String, User> users = (TreeMap<String, User>) ois.readObject();
        users.replace(user.getId(), user);

        FileOutputStream fos = new FileOutputStream(accFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(users);
        oos.flush();
        oos.close();
    }
}
