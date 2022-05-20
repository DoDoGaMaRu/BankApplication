package com.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class signUpController {

    public void signUp() throws IOException {
        Stage primaryStage = new Stage();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("signUp.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                primaryStage.setTitle("SignUp");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
    }
}
