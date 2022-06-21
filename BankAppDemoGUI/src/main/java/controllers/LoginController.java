package controllers;

import user.User;
import fileManager.UsersFileManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML private TextField idTextField;
    @FXML private TextField pwTextField;
    @FXML private Label errorLabel;


//    private User findUser(String id) throws IOException, ClassNotFoundException {
//        String filePath = "users";
//        File accFile = new File(filePath);
//        FileInputStream fis = new FileInputStream(accFile);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//
//        TreeMap<String, User> users = (TreeMap<String, User>) ois.readObject();
//
//        return users.get(id);
//    }


    public void login() throws IOException, ClassNotFoundException {
        String id = idTextField.getText();
        User crntUser = UsersFileManager.findUser(id);

        String pw = pwTextField.getText();

        if (crntUser.getPwd().equals(pw)) {
            closeStage();

            Stage primaryStage = new Stage();
            try {
                FXMLLoader loader = new FXMLLoader(BankApplication.class.getResource("selectAccount.fxml"));
                Scene scene = new Scene(loader.load());

                SelectAccountController selAccCon = loader.getController();
                selAccCon.setUser(crntUser);

                primaryStage.setTitle("SELECT");
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else {
            errorLabel.setText("ID or P/W is incorrect");
        }
    }

    public void enterLogin(KeyEvent keyEvent) throws IOException, ClassNotFoundException {
        if ( keyEvent.getCode().equals(KeyCode.ENTER) ) {
            login();
        }
    }



    public void signUp() {
        Stage signUpStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(BankApplication.class.getResource("signUp.fxml"));
            Scene scene = new Scene(loader.load());

            signUpStage.setTitle("SignUp");
            signUpStage.setScene(scene);
            signUpStage.initModality(Modality.APPLICATION_MODAL);
            signUpStage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }



    public void closeStage() {
        Stage stage = (Stage)idTextField.getScene().getWindow();
        stage.close();
    }
}