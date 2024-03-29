package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.dto.UserDto;
import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.MobileNo;
import lk.ijse.library.embedded.Name;
import lk.ijse.library.service.AdminService;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.impl.AdminServiceImpl;
import lk.ijse.library.util.Navigation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SignUpAdminFormController {

    @FXML
    private Button btnSignUp;

    @FXML
    private TextField txtAdminId;

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
    private TextField txtUserName;
    AdminService adminService= (AdminService) BoFactory.getBoFactory().getBo(BoFactory.BOType.ADMIN);
    @FXML
    void btnSignUpOnAction(ActionEvent event) {
        boolean isValidated=validateAdmin();
        if(isValidated) {
            AdminDto adminDto = new AdminDto();
            adminDto.setId(Integer.parseInt(txtAdminId.getText()));
            adminDto.setUserName(txtUserName.getText());
            adminDto.setAddress(setAddress());
            adminDto.setName(setName());
            adminDto.setPassword(txtPassword.getText());
            adminDto.setEmail(txtEmail.getText());
            adminDto.setMobileNo(setmobileNo().get(0));
            adminDto.setMobileNo(setmobileNo().get(1));
            try {
                boolean IsAdminSignedUp;
                IsAdminSignedUp = adminService.saveAdmin(adminDto);
                if (IsAdminSignedUp) {
                    LoginFormController.adminDto = adminService.getAdminId(txtUserName.getText());
                    Navigation.switchNavigation("AdminGlobalForm.fxml", event);
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
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
    private boolean validateAdmin() {
        String contxt=txtMobileNo.getText();
        String emailtext=txtEmail.getText();

        boolean cuscontactValidated=Pattern.matches("[0-9]{10}",contxt);
        boolean cusemailValidated=Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",emailtext);

        if(!cuscontactValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid customer tele no").show();
            return false;
        }
        if(!cusemailValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid customer email").show();
            return false;
        }
        return true;
    }

}
