package lk.ijse.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.UserDto;
import lk.ijse.library.service.UserService;
import lk.ijse.library.service.impl.UserServiceImpl;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class UserBarFormController {
    @FXML
    private Text txtAddress;

    @FXML
    private Text txtEmail;

    @FXML
    private Text txtId;

    @FXML
    private Text txtName;
    UserService userService=new UserServiceImpl();


    @FXML
    void deleteMouseClick(MouseEvent event) {
        try {
            int id= Integer.parseInt(txtId.getText());
            UserDto userDto=userService.getDtodata(id);
            boolean isDeleted = userService.deleteUser(userDto);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "User deleted").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void updateMouseClick(MouseEvent event) throws IOException {
        UpdateUserFormController.setId(Integer.parseInt((txtId.getText())));
        Navigation.popupPane("UpdateUserForm.fxml");
    }

    public void setData(int id) {
        UserDto userDto= null;
        try {
            userDto= userService.getDtodata(id);
            this.txtId.setText(String.valueOf(userDto.getId()));
            txtAddress.setText(userDto.getAddress().getCity());
            txtName.setText(userDto.getName().getFirstName());
            txtEmail.setText(userDto.getEmail());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
