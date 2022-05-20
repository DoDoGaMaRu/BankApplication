package com.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountOptionController {
    private Scene prevScene;
    private Account acc;

    @FXML
    private Label accNum;
    @FXML
    private Label balance;

    public void setAccount(Account acc) {
        this.acc = acc;
    }

    public void setPrevScene(Scene prevScene) {
        this.prevScene = prevScene;
    }

    public void back() throws IOException {
        Scene thisScene = accNum.getScene();
        Stage stage = (Stage) thisScene.getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("selectAccount.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("SELECT");
        stage.setScene(scene);
        stage.show();
    }
}
