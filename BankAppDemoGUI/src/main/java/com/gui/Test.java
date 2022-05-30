package com.gui;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "hello.txt";
        File accFile = new File(filePath);

        FileOutputStream fos = new FileOutputStream(accFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(new User("홍길동", "1234", "1234"));
        oos.flush();
        oos.close();

/*
        FileInputStream fio = new FileInputStream(accFile);
        BufferedInputStream bis = new BufferedInputStream(fio);
        ObjectInputStream ois = new ObjectInputStream(bis);

        User acc = (User)ois.readObject();

        acc.setName("백대환");
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