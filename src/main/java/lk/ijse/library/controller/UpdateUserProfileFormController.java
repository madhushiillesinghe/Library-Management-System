package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class UpdateUserProfileFormController {

    public static int id;
    @FXML
    private Button btnBack;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField lbluserHey;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtHomeMobile;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtMobileNo;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtStreet;

    @FXML
    private TextField txtTown;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Navigation.adminClosePaneUser();
    }

    @FXML
    void btnLogout(ActionEvent event) throws IOException {
    Navigation.switchNavigation("LoginForm.fxml",event);
    }

    @FXML
    void btnSetting(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
    }

    @FXML
    void btnchangepasswordOrUsername(ActionEvent event) {

    }

    @FXML
    void deleteAccount(ActionEvent event) {

    }

}
