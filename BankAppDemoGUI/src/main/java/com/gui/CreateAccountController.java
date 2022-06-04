package com.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.TreeMap;

public class CreateAccountController {
    private User user;

    @FXML private PasswordField pinField;
    @FXML private PasswordField pinConfirmField;
    @FXML private CheckBox checkBox;
    @FXML private TextField creditLimit;


    public void setUser(User user) {
        this.user = user;
    }

    public void select() {
        if ( checkBox.isSelected() ) {
            creditLimit.setDisable(false);
        }
        else {
            creditLimit.setDisable(true);
        }
    }


    public void create() throws IOException, ClassNotFoundException {
        TreeMap<Integer, Account> accounts;

        String pin = pinField.getText();
        String pinConfirm = pinConfirmField.getText();

        if (checkBox.isSelected()) {
            addAccount(true);
        } else {
            addAccount(false);
        }
        //user.addAccount(new Account(Integer.parseInt(pin), 0));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("CreateAccountSuccess");
        alert.setContentText("Your account is created!");
        alert.showAndWait();

        ((Stage) pinField.getScene().getWindow()).close();
    }

    private void addAccount(boolean isMinusAccount) throws IOException, ClassNotFoundException {
        String filePath = "accounts";
        File accFile = new File(filePath);
        FileInputStream fis = new FileInputStream(accFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        TreeMap<Integer, Account> accounts = (TreeMap<Integer, Account>) ois.readObject();

        if ( isMinusAccount ) {
            accounts.put(Integer.parseInt(pinField.getText()), new Account(Integer.parseInt(pinField.getText()), 0));
        } else {
            accounts.put(Integer.parseInt(pinField.getText()), new MinusAccount(Integer.parseInt(pinField.getText()), 0, Integer.parseInt(creditLimit.getText())));
        }

        FileOutputStream fos = new FileOutputStream(accFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(accounts);
        oos.flush();
        oos.close();
    }

    public void enterCreate(KeyEvent keyEvent) throws IOException, ClassNotFoundException {
        if ( keyEvent.getCode().equals(KeyCode.ENTER) ) {
            create();
        }
    }
}
