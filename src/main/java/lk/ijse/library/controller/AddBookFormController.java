package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.library.util.Navigation;

public class AddBookFormController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<?> cmbAdminId;

    @FXML
    private ComboBox<?> cmbBookGenre;

    @FXML
    private TextField txtBookAuthor;

    @FXML
    private TextField txtBookCount;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookName;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePane();
    }

    @FXML
    void cmbAdminIdOnAction(ActionEvent event) {

    }

    @FXML
    void cmbBookGenre(ActionEvent event) {

    }

}
