package main;

import account.Account;
import account.MinusAccount;
import fileManager.AccountsFileManager;
import fileManager.UsersFileManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import user.User;

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
        AccountsFileManager.findAccount(0);
        Account acc;

        String pin = pinField.getText();
        String pinConfirm = pinConfirmField.getText();

        if (checkBox.isSelected()) {
            acc = new MinusAccount(Integer.parseInt(pin), 0, Integer.parseInt(creditLimit.getText()));
            AccountsFileManager.addAccount(acc);

            user.addAccounts(acc.getAccountNumber());
            UsersFileManager.saveUser(user);
        }
        else {
            acc = new Account(Integer.parseInt(pin), 0);
            AccountsFileManager.addAccount(acc);

            user.addAccounts(acc.getAccountNumber());
            UsersFileManager.saveUser(user);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("CreateAccountSuccess");
        alert.setContentText("Your account is created!");
        alert.showAndWait();

        ((Stage) pinField.getScene().getWindow()).close();
    }

    public void enterCreate(KeyEvent keyEvent) throws IOException, ClassNotFoundException {
        if ( keyEvent.getCode().equals(KeyCode.ENTER) ) {
            create();
        }
    }
}
