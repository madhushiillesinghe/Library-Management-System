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
import lk.ijse.library.service.BoFactory;
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
    public static AdminDto adminDto;
    AdminService adminService= (AdminService) BoFactory.getBoFactory().getBo(BoFactory.BOType.ADMIN);



    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        boolean  verify=adminService.checkUserNameAndPassword(txtUserName.getText(),txtPassword.getText());
        if(verify) {
            adminDto=adminService.getAdminId(txtUserName.getText());
            System.out.println("Admin dto"+adminDto);
            Navigation.switchNavigation("AdminGlobalForm.fxml", event);
        }else
            System.out.println("unable to sign in");
    }

    @FXML
    void forgetPsswordOnMouseClick(MouseEvent event) {

    }

    @FXML
    void AdminAccountSignUpOnMouseClick(MouseEvent event) throws IOException {
    Navigation.switchNavigation("SignUpAdminForm.fxml",event);
    }

    }

