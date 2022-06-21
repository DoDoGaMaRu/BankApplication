package com.gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DepositMenuController {
    private int amount;

    private Account account;

    @FXML private TextField depositAmount;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAccount(Account acc) {
        this.account = acc;
    }



    public void deposit() {
        account.deposit(amount);

        ((Stage)depositAmount.getScene().getWindow()).close();
    }
}
