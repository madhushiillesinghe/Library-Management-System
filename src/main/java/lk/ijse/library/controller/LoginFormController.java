package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.MobileNo;
import lk.ijse.library.embedded.Name;
import lk.ijse.library.entity.Admin;
import lk.ijse.library.service.AdminService;
import lk.ijse.library.service.impl.AdminServiceImpl;
import lk.ijse.library.util.Navigation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginFormController {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;
    AdminService adminService=new AdminServiceImpl();



    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String username=txtUserName.getText();
        Navigation.switchNavigation("AdminGlobalForm.fxml",event);
    }

    @FXML
    void forgetPsswordOnMouseClick(MouseEvent event) {

    }

    @FXML
    void AdminAccountSignUpOnMouseClick(MouseEvent event) throws IOException {
    Navigation.switchNavigation("SignUpAdminForm.fxml",event);
    }

    @FXML
    void UserAccountSignUpOnMouseClick(MouseEvent event) throws IOException {
        Navigation.switchNavigation("SignUpUserForm.fxml",event);

    }
    }

