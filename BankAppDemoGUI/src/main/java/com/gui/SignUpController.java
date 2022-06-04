package com.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;

public class SignUpController {
    @FXML private TextField name;
    @FXML private TextField id;
    @FXML private PasswordField pw;
    @FXML private PasswordField pwConfirm;


    public void enterSignUp(KeyEvent keyEvent) throws IOException, ClassNotFoundException {
        if ( keyEvent.getCode().equals(KeyCode.ENTER) ) {
            signUp();
        }
    }

    public void signUp() throws IOException, ClassNotFoundException {
        String password = pw.getText();
        String passwordConfirm = pwConfirm.getText();

        if( password.equals(passwordConfirm) ) {
            UsersFileManager.addUser(new User(name.getText(), id.getText(), pw.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("SignUpSuccess");
            alert.setContentText("SignUp Success!");
            alert.showAndWait();

            closeStage();

        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("SignUpFailed");
            alert.setContentText("password and confirm password is different!");
            alert.showAndWait();
        }
    }

    public void closeStage() {
        Stage stage = (Stage) pwConfirm.getScene().getWindow();
        stage.close();
    }
}
