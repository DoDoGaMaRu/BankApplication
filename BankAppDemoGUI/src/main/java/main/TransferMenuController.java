package main;

import account.Account;
import fileManager.AccountsFileManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TransferMenuController {
    private Account account;

    @FXML private Label balance;
    @FXML private Label messageLabel;
    @FXML private TextField enteredAccNum;
    @FXML private TextField transferAmount;

    public void setAccount(Account acc) {
        this.account = acc;
        balance.setText(Integer.toString(account.getBalance()));
    }

    public void transfer() throws IOException, ClassNotFoundException {
        int toAccNum = Integer.parseInt(enteredAccNum.getText());
        int amount = Integer.parseInt(transferAmount.getText());
        Account toAcc = AccountsFileManager.findAccount(toAccNum);

        try{
            account.transfer(toAcc, amount);
            AccountsFileManager.saveAccount(account);
            AccountsFileManager.saveAccount(toAcc);
            back();
        }
        catch (NullPointerException e) {
            messageLabel.setText("Error : Account not found");
        }
        catch (Exception e) {
            messageLabel.setText("Error : Not enough money");
        }
    }

    public void back() {
        ((Stage)enteredAccNum.getScene().getWindow()).close();
    }
}
