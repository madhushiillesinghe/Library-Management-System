package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class BranchesFormController {

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBrachesManage;

    @FXML
    void btnAddBraches(ActionEvent event) throws IOException {
        Navigation.popupPane("AddBranchForm.fxml");
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

}
