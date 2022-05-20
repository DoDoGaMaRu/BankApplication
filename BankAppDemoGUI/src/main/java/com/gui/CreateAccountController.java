package com.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CreateAccountController {

    private User user;

    private static int accNum = 1;

    private ListView<String> accountList;
    @FXML
    private PasswordField pinField;

    @FXML
    private PasswordField pinConfirmField;
    public void setUser(User user) {
        this.user = user;
    }


    public void create() {


        String pin = pinField.getText();
        String pinConfirm = pinConfirmField.getText();

        if ( pin.equals(pinConfirm) ) {

            accountList.getItems().add(new Account(++accNum, Integer.parseInt(pin), 0).toString());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("CreateAccountSuccess");
            alert.setContentText("Your account is created!");
            alert.showAndWait();

            ((Stage) pinConfirmField.getScene().getWindow()).close();

        } else {
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

    public void setAccountList(ListView<String> accountList) {
        this.accountList = accountList;
    }
}
