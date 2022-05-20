module com.example.demogui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gui to javafx.fxml;
    exports com.gui;
}