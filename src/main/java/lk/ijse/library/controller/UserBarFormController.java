package lk.ijse.library.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class UserBarFormController {

    @FXML
    void deleteMouseClick(MouseEvent event) {

    }

    @FXML
    void updateMouseClick(MouseEvent event) throws IOException {
        Navigation.popupPane("UpdateUserForm.fxml");
    }

}
