package main;

import account.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AccountController {
    private Scene prevScene;
    private Account acc;

    @FXML private Label accNum;
    @FXML private Label balance;
    @FXML private Label messageLabel;
    @FXML private TextField pwTextField;


    public void setAccount(Account acc) {
        this.acc = acc;
        accNum.setText(String.format("%d",acc.getAccountNumber()));
        balance.setText(String.format("%d",acc.getBalance()));
    }

    public void setPrevScene(Scene prevScene) {
        this.prevScene = prevScene;
    }



    public void deposit() {
        if ( acc.validatePIN(Integer.parseInt(pwTextField.getText())) ) {
            Stage stage = new Stage();
            try{
                FXMLLoader loader = new FXMLLoader(BankApplication.class.getResource("depositMenu.fxml"));
                Scene scene = new Scene(loader.load());

                DepositMenuController con = loader.getController();
                con.setAccount(acc);
                stage.setTitle("DepositMenu");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            messageLabel.setText("Wrong Pin!");
        }
    }

    public void withdraw() {
        if ( acc.validatePIN(Integer.parseInt(pwTextField.getText())) ) {
            Stage stage = new Stage();
            try{
                FXMLLoader loader = new FXMLLoader(BankApplication.class.getResource("withdrawMenu.fxml"));
                Scene scene = new Scene(loader.load());

                WithdrawMenuController con = loader.getController();
                con.setAccount(acc);
                stage.setTitle("WithdrawMenu");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            messageLabel.setText("Wrong Pin!");
        }
    }

    public void transfer() {
        if ( acc.validatePIN(Integer.parseInt(pwTextField.getText())) ) {
            Stage stage = new Stage();
            try{
                FXMLLoader loader = new FXMLLoader(BankApplication.class.getResource("transferMenu.fxml"));
                Scene scene = new Scene(loader.load());

                TransferMenuController con = loader.getController();
                con.setAccount(acc);
                stage.setTitle("TransferMenu");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            messageLabel.setText("Wrong Pin!");
        }
    }


    public void refresh() {
        balance.setText(String.format("%d",acc.getBalance()));
    }



    public void back() {
        Scene thisScene = accNum.getScene();
        Stage stage = (Stage) thisScene.getWindow();

        stage.setTitle("SELECT");
        stage.setScene(prevScene);
    }
}
