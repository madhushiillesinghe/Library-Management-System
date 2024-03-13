package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

import java.util.ArrayList;
import java.util.List;

public class SignUpUserFormController {
    UserService userService= (UserService) BoFactory.getBoFactory().getBo(BoFactory.BOType.USERS);

    @FXML
    private Button btnSignUp;

    @FXML
    private TextField txtCity;

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
    private TextField txtUserId;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnSignUpOnAction(ActionEvent event) {

        UserDto userDto=new UserDto();
        userDto.setId(Integer.parseInt(txtUserId.getText()));
        userDto.setUserName(txtUserName.getText());
        userDto.setAddress(setAddress());
        userDto.setName(setName());
        userDto.setPassword(txtPassword.getText());
        userDto.setEmail(txtEmail.getText());
        userDto.setMobileNo(setmobileNo().get(0));
        userDto.setMobileNo(setmobileNo().get(1));
        try{
            boolean IsUserSignedUp;
            IsUserSignedUp= userService.saveUser(userDto);
            if(IsUserSignedUp){

                UserProfileFormController.id=userDto.getId();
                UserProfileFormController.password=userDto.getPassword();
                UpdateUserProfileFormController.id=userDto.getId();

                //System.out.println("id"+userDto.getId());
                new Alert(Alert.AlertType.CONFIRMATION, "User Account Sign up successfully!").show();
                Navigation.switchNavigation("UserGlobalForm.fxml",event);
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

}
