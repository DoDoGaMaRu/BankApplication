package com.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

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


    public void create() {
        TreeMap<Integer, Account> accounts;

        String pin = pinField.getText();
        String pinConfirm = pinConfirmField.getText();

        if ( pin.equals(pinConfirm) ) {
            Account acc;
            if (checkBox.isSelected() ) {
                int limit = Integer.parseInt(creditLimit.getText());
                acc = new MinusAccount(Integer.parseInt(pin), 0, limit);
            } else {
                acc = new Account(Integer.parseInt(pin), 0);
            }
            //user.addAccount(new Account(Integer.parseInt(pin), 0));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("CreateAccountSuccess");
            alert.setContentText("Your account is created!");
            alert.showAndWait();

            ((Stage)pinField.getScene().getWindow()).close();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("CreateAccountFailed");
            alert.setContentText("pin and confirm pin is different!");
            alert.showAndWait();
        }
    }

    public void enterCreate(KeyEvent keyEvent){
        if ( keyEvent.getCode().equals(KeyCode.ENTER) ) {
            create();
        }
    }
}
