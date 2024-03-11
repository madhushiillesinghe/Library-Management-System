package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.UserDto;
import lk.ijse.library.service.UserService;
import lk.ijse.library.service.impl.UserServiceImpl;
import lk.ijse.library.util.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewUserFormController implements Initializable {

    public static int id;
    @FXML
    private Button btnCancel;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblHomeMobile;

    @FXML
    private TextField lblLastName;

    @FXML
    private Label lblMobileNo;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblStreet;

    @FXML
    private Label lblUserId;

    @FXML
    private Label lblUserName;
    @FXML
    private TextField lblEmail;
    UserService userService=new UserServiceImpl();
    public static void setId(int id) {
        ViewUserFormController.id=id;

    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePane();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }

    private void setData() {
        try{
            UserDto userDto = userService.getData((id));
            lblCity.setText(userDto.getAddress().getCity());
            lblEmail.setText(userDto.getEmail());
            lblStreet.setText(userDto.getAddress().getStreet());
            lblFirstName.setText(userDto.getName().getFirstName());
            lblPassword.setText(userDto.getPassword());
            lblHomeMobile.setText(userDto.getMobileNo().getMobileNo());
            lblMobileNo.setText(userDto.getMobileNo().getMobileNo());
            lblUserName.setText(userDto.getUserName());
            lblLastName.setText(userDto.getName().getLastName());
            lblUserId.setText(String.valueOf(userDto.getId()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
