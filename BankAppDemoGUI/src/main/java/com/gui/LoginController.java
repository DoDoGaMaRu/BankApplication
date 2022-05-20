package com.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private TextField idTextField;
    @FXML
    private TextField pwTextField;

    @FXML
    public void login() {
        String id = idTextField.getText();
        String pw = pwTextField.getText();

        if (id.equals("admin") && pw.equals("1234")) {
            closeStage();

            Stage primaryStage = new Stage();
            try {
                FXMLLoader loader = new FXMLLoader(BankApplication.class.getResource("selectAccount.fxml"));
                Scene scene = new Scene(loader.load());

                primaryStage.setTitle("SELECT");
                primaryStage.setScene(scene);

                SelectAccountController selAccCon = loader.<SelectAccountController>getController();
                selAccCon.setUser(new User("홍길동"));

                primaryStage.show();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void signUp() {
        Stage signUpStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(BankApplication.class.getResource("signUp.fxml"));
            Scene scene = new Scene(loader.load());

            signUpStage.setTitle("SignUp");
            signUpStage.setScene(scene);
            signUpStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void closeStage() {
        Stage stage = (Stage) idTextField.getScene().getWindow();
        stage.close();
    }

    public void enterLogin(KeyEvent keyEvent) {
        if ( keyEvent.getCode().equals(KeyCode.ENTER) ) {
            login();
        }
    }

}