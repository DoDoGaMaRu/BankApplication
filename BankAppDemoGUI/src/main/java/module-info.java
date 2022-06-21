module com.example.demogui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gui to javafx.fxml;
    exports com.gui;
    exports account;
    opens account to javafx.fxml;
    exports fileManager;
    opens fileManager to javafx.fxml;
}