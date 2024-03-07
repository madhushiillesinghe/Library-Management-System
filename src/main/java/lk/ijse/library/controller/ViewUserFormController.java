package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.library.util.Navigation;

public class ViewUserFormController {

    @FXML
    private Button btnCancel;

    @FXML
    private Label lblAdminId;

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

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePane();
    }

}
