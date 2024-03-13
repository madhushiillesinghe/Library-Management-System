package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.library.dto.UserDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.UserService;
import lk.ijse.library.service.impl.UserServiceImpl;
import lk.ijse.library.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserProfileFormController implements Initializable {

    public static int id;
    public static String password;
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
    private TextField lblId;
    @FXML
    public AnchorPane userPaneId;
    @FXML
    public AnchorPane AnchorPaneId;


    private static UserProfileFormController controller;
    public UserProfileFormController(){
        controller=this;
    }
    public  static UserProfileFormController  getInstance(){

        return controller;
    }

    UserService userService= (UserService) BoFactory.getBoFactory().getBo(BoFactory.BOType.USERS);

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
    Navigation.switchPagingUser(userPaneId, "UserProfileForm.fxml");
    }


    @FXML
    void btnchangepasswordOrUsername(ActionEvent event) throws IOException {
        UpdateUserProfileFormController.id= Integer.parseInt(lblId.getText());
        Navigation.switchPagingUser(UserGlobalFormController.getInstance().paneId, "UpdateUserProfileForm.fxml");
    }
    @FXML
    void deleteAccount(ActionEvent event) {
        try {

            UserDto userDto=userService.getDtodata(id);
            boolean isDeleted = userService.deleteUser(userDto);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "User deleted").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
    @FXML
    void btnLogout(ActionEvent event) throws IOException {
        Navigation.switchNavigation("UserOrAdminForm.fxml",event);
    }

    @FXML
    void btnSetting(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbluserHey.setText(password);
        setData();
    }

    private void setData() {
        try{
            UserDto userDto = userService.getData((id));
            lblId.setText(String.valueOf(userDto.getId()));
            lblTown.setText(userDto.getAddress().getCity());
            lblEmail.setText(userDto.getEmail());
            lblStreet.setText(userDto.getAddress().getStreet());
            lblFullName.setText(userDto.getName().getFirstName());
            lblPassword.setText(userDto.getPassword());
            lblHomeMobile.setText(userDto.getMobileNo().getMobileNo());
            lblMobileNo.setText(userDto.getMobileNo().getMobileNo());
            lblUserName.setText(userDto.getUserName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
