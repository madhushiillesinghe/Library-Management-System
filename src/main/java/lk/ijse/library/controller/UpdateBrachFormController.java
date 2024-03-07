package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.library.util.Navigation;

public class UpdateBrachFormController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<?> cmbAdminId;

    @FXML
    private ComboBox<?> cmblocation;

    @FXML
    private TextField txtBookCount;

    @FXML
    private TextField txtBrachId;

    @FXML
    private TextField txtBranchHead;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePane();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void cmbAdminIdOnAction(ActionEvent event) {

    }

    @FXML
    void cmbLocationOnAction(ActionEvent event) {

    }

}
