package com.gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TransferMenuController {
    private int amount;
    private Account account;

    @FXML private TextField enteredAccNum;



    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAccount(Account acc) {
        this.account = acc;
    }



    public void transfer() {
        int accNum = Integer.parseInt(enteredAccNum.getText());

        account.transfer(accNum, amount);

        ((Stage)enteredAccNum.getScene().getWindow()).close();
    }
}
