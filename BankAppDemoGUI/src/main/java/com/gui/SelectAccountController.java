package com.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SelectAccountController {
    private User user;

    @FXML private Label userName;
    @FXML private ListView<Account> accountList;


    public void setUser(User user) {
        this.user = user;
        userName.setText(user.getName());
        refreshAccList();
    }

    public void refreshAccList() {
        accountList.getItems().clear();
        ArrayList<Account> accounts = user.getAccounts();

        for(Account acc : accounts) {
            accountList.getItems().add(acc);
        }
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
        Stage createAccStage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("createAccount.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        CreateAccountController createAccCon = fxmlLoader.getController();
        createAccCon.setUser(this.user);

        createAccStage.setTitle("CREATE_ACCOUNT");
        createAccStage.setScene(scene);
        createAccStage.initModality(Modality.APPLICATION_MODAL);
        createAccStage.show();
    }



    public void select() throws IOException {
        Scene thisScene = userName.getScene();
        Stage stage = (Stage) thisScene.getWindow();


        FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("accountOption.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        AccountOptionController accOptionCon = fxmlLoader.getController();
        accOptionCon.setAccount(accountList.getSelectionModel().getSelectedItem());
        accOptionCon.setPrevScene(thisScene);

        stage.setTitle("ACCOUNT_OPTION");
        stage.setScene(scene);
    }
}
