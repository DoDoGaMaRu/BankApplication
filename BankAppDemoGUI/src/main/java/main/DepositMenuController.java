package main;

import account.Account;
import fileManager.AccountsFileManager;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DepositMenuController {
    private Account acc;

    @FXML private Label balance;
    @FXML private TextField depositAmount;

    public void setAccount(Account acc) {
        this.acc = acc;
        balance.setText(String.format("%d",acc.getBalance()));
    }

    public void deposit() throws IOException, ClassNotFoundException {
        acc.deposit(Integer.parseInt(depositAmount.getText()));
        balance.setText(String.format("%d",acc.getBalance()));
        AccountsFileManager.saveAccount(acc);

        back();
    }

    public void back() {
        Scene thisScene = balance.getScene();
        Stage stage = (Stage) thisScene.getWindow();

        stage.close();
    }
}