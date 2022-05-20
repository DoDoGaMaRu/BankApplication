package com.gui;

import javafx.event.ActionEvent;
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
    private ListView<String> accountList;

    private User user;

    public void setUser(User user) {
        this.user = user;
        userName.setText(user.getName());
        accountList.getItems().add(user.getAccount().toString());
    }


    public void logout() throws IOException {
        Stage stage = (Stage) userName.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("BANK APP");
        stage.setScene(scene);
        stage.show();
    }



    public void createAccount() throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("createAccount.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("CREATE_ACCOUNT");
        stage.setScene(scene);
        stage.show();
    }

    public void select(ActionEvent actionEvent) throws IOException {
        Scene thisScene = userName.getScene();
        Stage stage = (Stage) thisScene.getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("accountOption.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("CREATE_ACCOUNT");
        stage.setScene(scene);

        AccountOptionController accOptionCon = fxmlLoader.getController();
        accOptionCon.setAccount(user.getAccount());
        accOptionCon.setPrevScene(thisScene);

        stage.show();
    }
}
