package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lk.ijse.library.util.Navigation;

public class ViewBookFormController {

    @FXML
    private Button btnCancel;

    @FXML
    private Label lblAdminId;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblBookCount;

    @FXML
    private Label lblBookGenre;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBookName;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePane();
    }

}
