package lk.ijse.library.controller;

import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class BookUserBarFormController {

    @FXML
    void viewBookOnMouseClick(MouseEvent event) throws IOException {
        Navigation.popupPaneUser("viewBookForm.fxml");
    }

}
