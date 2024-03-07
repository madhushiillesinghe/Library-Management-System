package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class BookFormController {

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBookManage;

    @FXML
    void btnAddBookOnAction(ActionEvent event) throws IOException {
        Navigation.popupPane("AddBookForm.fxml");

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

}
