package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class UserOrAdminFormController {

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnUser;

    @FXML
    void btnAdminOnAction(ActionEvent event) throws IOException {
    Navigation.switchNavigation("LoginForm.fxml",event);
    }

    @FXML
    void btnUserOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("UserLogin.fxml",event);
    }
}
