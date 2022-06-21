package main;

import account.Account;
import fileManager.AccountsFileManager;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class WithdrawMenuController {

    @FXML private Label balance;
    @FXML private TextField withdrawAmount;

    @FXML private Label messageLabel;

    private int amount;

    private Account account;

    public void setAccount(Account account) {
        this.account = account;
        balance.setText(Integer.toString(account.getBalance()));
    }

    public void withdraw() throws IOException, ClassNotFoundException {
        amount = Integer.parseInt(withdrawAmount.getText());
        try {
            account.withdraw(amount);
            messageLabel.setText("Withdraw completed!");
            AccountsFileManager.saveAccount(account);
            ((Stage)withdrawAmount.getScene().getWindow()).close();
        } catch (Exception e) {
            messageLabel.setText("error : Not enough money");
        }
    }

    public void back() {
        Scene thisScene = withdrawAmount.getScene();
        Stage stage = (Stage) thisScene.getWindow();

        stage.close();
    }

}
