package com.gui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountOptionController {
    private Scene prevScene;
    private Account acc;

    @FXML private Label accNum;
    @FXML private Label balance;
    @FXML private TextField amount;

    public void setAccount(Account acc) {
        this.acc = acc;
        accNum.setText(String.format("%d",acc.getAccountNumber()));
        balance.setText(String.format("%d",acc.getBalance()));
    }

    public void setPrevScene(Scene prevScene) {
        this.prevScene = prevScene;
    }



    public void back() throws IOException {
        Scene thisScene = accNum.getScene();
        Stage stage = (Stage) thisScene.getWindow();

        stage.setTitle("SELECT");
        stage.setScene(prevScene);
    }
}
