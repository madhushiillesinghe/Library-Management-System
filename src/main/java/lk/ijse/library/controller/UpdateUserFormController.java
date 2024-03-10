package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.library.dto.UserDto;
import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.MobileNo;
import lk.ijse.library.embedded.Name;
import lk.ijse.library.service.UserService;
import lk.ijse.library.service.impl.UserServiceImpl;
import lk.ijse.library.util.Navigation;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateUserFormController implements Initializable {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField txtUserIdId;

    @FXML
    private TextField txtCity;

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
    private TextField txtUserName;
    @FXML
    private TextField txtEmail;
    UserService userService=new UserServiceImpl();
    public static int id;


    public static void setId(int i) {
        UpdateUserFormController.id = i;

    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePane();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        UserDto userDto=new UserDto();
        userDto.setId(Integer.parseInt(txtUserIdId.getText()));
        userDto.setUserName(txtUserName.getText());
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
        address.setCity(txtCity.getText());
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }

    private void setData() {
        UserDto userDto=userService.getDtodata(UpdateUserFormController.id);
        System.out.println(userDto);
        userDto.setId(Integer.parseInt(txtUserIdId.getText()));
        userDto.setUserName(txtUserName.getText());
        userDto.setAddress(setAddress());
        userDto.setName(setName());
        userDto.setPassword(txtPassword.getText());
        userDto.setEmail(txtEmail.getText());
        userDto.setMobileNo(setmobileNo().get(0));
        userDto.setMobileNo(setmobileNo().get(1));
    }
}
