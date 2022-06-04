package com.gui;

import java.io.*;
import java.util.TreeMap;

public class UsersFileManager {
    private static String filePath = "users";

    public static void addUser(User user) throws IOException, ClassNotFoundException {
        File accFile = new File(filePath);
        FileInputStream fis = new FileInputStream(accFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        TreeMap<String, User> users = (TreeMap<String, User>) ois.readObject();

        users.put(user.getId(), user);

        FileOutputStream fos = new FileOutputStream(accFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(users);
        oos.flush();
        oos.close();
    }

    public static void saveUser(User user) throws IOException, ClassNotFoundException {
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

    public static User findUser(String id) throws IOException, ClassNotFoundException {
        File accFile = new File(filePath);
        FileInputStream fis = new FileInputStream(accFile);
        ObjectInputStream ois = new ObjectInputStream(fis);

        TreeMap<String, User> users = (TreeMap<String, User>) ois.readObject();

        return users.get(id);
    }
}
