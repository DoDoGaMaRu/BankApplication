package com.gui;

import java.io.*;
import java.util.TreeMap;

public class UsersFileManager {
    private static String filePath = "users";

    public static void addUser(User user) throws IOException, ClassNotFoundException {
        TreeMap<String, User> users = getTreeMap(new File(filePath));

        users.put(user.getId(), user);

        writeFile(new File(filePath), users);
    }

    public static void saveUser(User user) throws IOException, ClassNotFoundException {

        TreeMap<String, User> users = getTreeMap(new File(filePath));
        users.replace(user.getId(), user);

        writeFile(new File(filePath), users);
    }

    public static User findUser(String id) throws IOException, ClassNotFoundException {
        TreeMap<String, User> users = getTreeMap(new File(filePath));

        return users.get(id);
    }

    private static TreeMap getTreeMap(File accFile) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(accFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        TreeMap<String, User> users = (TreeMap<String, User>) ois.readObject();

        return users;
    }

    private static void writeFile(File accFile, TreeMap users) throws IOException {
        FileOutputStream fos = new FileOutputStream(accFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(users);
        oos.flush();
        oos.close();
    }
}
