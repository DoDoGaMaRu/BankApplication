package main;

import account.Account;
import fileManager.AccountsFileManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TransferMenuController {
    private Account account;

    @FXML private TextField enteredAccNum;
    @FXML private TextField transferAmount;

    public void setAccount(Account acc) {
        this.account = acc;
    }

    public void transfer(ActionEvent actionEvent) throws Exception {
        int toAccNum = Integer.parseInt(enteredAccNum.getText());
        int amount = Integer.parseInt(transferAmount.getText());

        account.withdraw(amount);
        Account toAcc = AccountsFileManager.findAccount(toAccNum);
        toAcc.deposit(amount);

        AccountsFileManager.saveAccount(account);
        AccountsFileManager.saveAccount(toAcc);

        ((Stage)enteredAccNum.getScene().getWindow()).close();
    }

    public void back(ActionEvent actionEvent) {
        ((Stage)enteredAccNum.getScene().getWindow()).close();
    }
}
