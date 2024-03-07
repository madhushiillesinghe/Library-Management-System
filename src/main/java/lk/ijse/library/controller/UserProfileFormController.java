package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class UserProfileFormController {

    @FXML
    private Button btnBack;

    @FXML
    private TextField lblEmail;

    @FXML
    private TextField lblFullName;

    @FXML
    private TextField lblHomeMobile;

    @FXML
    private TextField lblMobileNo;

    @FXML
    private TextField lblPassword;

    @FXML
    private TextField lblStreet;

    @FXML
    private TextField lblTown;

    @FXML
    private TextField lblUserName;

    @FXML
    private TextField lbluserHey;
    @FXML
    public AnchorPane userPaneId;

    private static UserProfileFormController controller;
    public UserProfileFormController(){
        controller=this;
    }
    public  static UserProfileFormController  getInstance(){
        return controller;
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
    Navigation.
            switchPagingUserProfile(userPaneId, "UserProfileForm.fxml");
    }


    @FXML
    void btnchangepasswordOrUsername(ActionEvent event) throws IOException {
        Navigation.switchPagingUserProfile(userPaneId, "UpdateUserProfileForm.fxml");
    }
    @FXML
    void deleteAccount(ActionEvent event) {

    }
    @FXML
    void btnLogout(ActionEvent event) throws IOException {
        Navigation.switchNavigation("LoginForm.fxml",event);
    }

    @FXML
    void btnSetting(ActionEvent event) {

    }

}
