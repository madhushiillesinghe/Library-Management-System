package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("AdminGlobalForm.fxml",event);
    }

    @FXML
    void forgetPsswordOnMouseClick(MouseEvent event) {

    }

    @FXML
    void signUpOnMouseClick(MouseEvent event) {

    }

}
