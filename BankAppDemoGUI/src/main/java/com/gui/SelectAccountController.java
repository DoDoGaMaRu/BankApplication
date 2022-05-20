package com.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectAccountController {
    @FXML
    private Label userName;
    @FXML
    private ListView accountList;

    private User user;

    public void setUser(User user) {
        this.user = user;
        userName.setText(user.getName());
    }

    public void roadAccounts() {
        // accountList.
        // 만들어야할듯
    }

    @FXML
    public void logout() throws IOException {
        Stage stage = (Stage) userName.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("BANK APP");
        stage.setScene(scene);
        stage.show();
    }
}
