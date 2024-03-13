package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lk.ijse.library.dto.UserDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.UserService;
import lk.ijse.library.service.impl.UserServiceImpl;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class UserLoginFormController {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;
    UserService userService= (UserService) BoFactory.getBoFactory().getBo(BoFactory.BOType.USERS);
    public  static UserDto userDto;

    @FXML
    void UserAccountSignUpOnMouseClick(MouseEvent event) throws IOException {
        Navigation.switchNavigation("SignUpUserForm.fxml",event);

    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        boolean  verify=userService.checkUserNameAndPassword(txtUserName.getText(),txtPassword.getText());
        if(verify) {
            userDto=userService.getUserId(txtUserName.getText());
            UserProfileFormController.id=userDto.getId();
            UserProfileFormController.password=userDto.getPassword();
            UpdateUserProfileFormController.id=userDto.getId();

            Navigation.switchNavigation("UserGlobalForm.fxml", event);
        }else
            System.out.println("unable to sign in");
    }

    @FXML
    void forgetPsswordOnMouseClick(MouseEvent event) {

    }

}
