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
    AdminService adminService=new AdminServiceImpl();



    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        adminService.saveAdmin(setData());
        String username=txtUserName.getText();
        Navigation.switchNavigation("AdminGlobalForm.fxml",event);
    }

    @FXML
    void forgetPsswordOnMouseClick(MouseEvent event) {

    }

    @FXML
    void signUpOnMouseClick(MouseEvent event) {

    }
    private static AdminDto setData() {
        Admin admin=new Admin();
        admin.setMobileNo(setMobileNo().get(0));
        admin.setMobileNo(setMobileNo().get(1));
        admin.setAddress(setAddress());
        admin.setName(setName());
        admin.setId(1);
        admin.setEmail("madhushiillesinghe225@gmail.com");
        AdminDto adminDto=new AdminDto(admin.getId(),admin.getName(),admin.getEmail(),admin.getMobileNo(),admin.getAddress());
        return adminDto;
    }

    private static List<MobileNo> setMobileNo() {
        List<MobileNo> mobileNoList=new ArrayList<>();
        MobileNo mobileNo=new MobileNo();
        mobileNo.setMobileNo("0776210846");
        mobileNo.setType("Mobile");
        mobileNoList.add(mobileNo);

        MobileNo  mobileNo1=new MobileNo();
        mobileNo1.setMobileNo("0913915090");
        mobileNo1.setType("Home");
        mobileNoList.add(mobileNo1);
        return  mobileNoList;
    }

    private static Address setAddress() {
        Address address=new Address();
        address.setCity("Galle");
        address.setStreet("Mahamodar");
        return address;
    }

    private static Name setName() {
        Name name=new Name();
        name.setFirstName("kamal");
        name.setLastName("Gmage");
        return name;
    }
}
