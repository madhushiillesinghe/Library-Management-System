package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.library.dto.UserDto;
import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.MobileNo;
import lk.ijse.library.embedded.Name;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.UserService;
import lk.ijse.library.service.impl.UserServiceImpl;
import lk.ijse.library.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateUserProfileFormController implements Initializable {

    public static int id;
    @FXML
    private Button btnBack;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField lbluserHey;

    @FXML
    private TextField txtUserId;

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
    UserService userService= (UserService) BoFactory.getBoFactory().getBo(BoFactory.BOType.USERS);


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
        UserDto userDto=new UserDto();
        userDto.setUserName(txtUserName.getText());
        userDto.setId(Integer.parseInt(txtUserId.getText()));
        userDto.setAddress(setAddress());
        userDto.setName(setName());
        userDto.setPassword(txtPassword.getText());
        userDto.setEmail(txtEmail.getText());
        userDto.setMobileNo(setmobileNo().get(0));
        userDto.setMobileNo(setmobileNo().get(1));
        try{
            boolean IsUserUpdate;
            IsUserUpdate= userService.updateUser(userDto);
            if(IsUserUpdate){
                new Alert(Alert.AlertType.CONFIRMATION, "User Updated Successfull").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();


        }

    }
    private Name setName() {
        Name name=new Name() ;
        name.setLastName(txtLastName.getText());
        name.setFirstName(txtFirstName.getText());
        return name;
    }

    private Address setAddress() {
        Address address=new Address();
        address.setStreet(txtStreet.getText());
        address.setCity(txtTown.getText());
        return address;
    }
    private List<MobileNo> setmobileNo(){
        MobileNo mobileNo1=new MobileNo();
        List<MobileNo>Nos=new ArrayList<>();
        mobileNo1.setMobileNo(txtMobileNo.getText());
        mobileNo1.setType("Mobile");

        MobileNo mobileNo2=new MobileNo();
        mobileNo2.setMobileNo(txtHomeMobile.getText());
        mobileNo2.setType("Home");

        Nos.add(mobileNo1);
        Nos.add(mobileNo2);
        return Nos;

    }

    @FXML
    void btnchangepasswordOrUsername(ActionEvent event) {
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
    private void setData() {
        try{
            UserDto userDto = userService.getData((id));
            txtUserId.setText(String.valueOf(userDto.getId()));
            txtTown.setText(userDto.getAddress().getCity());
            txtEmail.setText(userDto.getEmail());
            txtStreet.setText(userDto.getAddress().getStreet());
            txtFirstName.setText(userDto.getName().getFirstName());
            txtPassword.setText(userDto.getPassword());
            txtHomeMobile.setText(userDto.getMobileNo().getMobileNo());
            txtMobileNo.setText(userDto.getMobileNo().getMobileNo());
            txtUserName.setText(userDto.getUserName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }
}
