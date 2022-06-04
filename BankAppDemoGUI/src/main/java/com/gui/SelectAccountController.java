package com.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeMap;

public class SelectAccountController {
    private User user;
    private ArrayList<Account> userAccounts = new ArrayList<>();

    @FXML private Label userName;
    @FXML private ListView<Account> accountList;


    public void setUser(User user) throws IOException, ClassNotFoundException {
        this.user = user;
        userName.setText(user.getName());
        refreshAccList();
    }

    public void refreshAccList() throws IOException, ClassNotFoundException {
        accountList.getItems().clear();

        ArrayList<Integer> userAccountsNum = user.getAccounts();

        userAccounts = new ArrayList<>();
        for(Integer accNum : userAccountsNum) {
            userAccounts.add(findAccount(accNum));
        }

        for(Account acc : userAccounts) {
            accountList.getItems().add(acc);
        }

    }

    private Account findAccount(int accountNumber) throws IOException, ClassNotFoundException {
        String filePath = "accounts";
        File accFile = new File(filePath);
        FileInputStream fis = new FileInputStream(accFile);
        ObjectInputStream ois = new ObjectInputStream(fis);

        TreeMap<Integer, Account> accounts = (TreeMap<Integer, Account>) ois.readObject();

        return accounts.get(accountNumber);
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

    public void logout() throws IOException, ClassNotFoundException {
        UsersFileManager.saveUser(user);
        Stage stage = (Stage) userName.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("BANK APP");
        stage.setScene(scene);
        stage.show();
    }
}
