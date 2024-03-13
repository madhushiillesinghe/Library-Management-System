package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.UserDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.UserService;
import lk.ijse.library.service.impl.UserServiceImpl;
import lk.ijse.library.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxUserManage;

    UserService userService= (UserService) BoFactory.getBoFactory().getBo(BoFactory.BOType.USERS);
    private static UserFormController controller;
    public UserFormController(){
        controller=this;
    }
    public static UserFormController getInstance(){
        return controller;
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws IOException {
        List<Integer> userDtoList=userService.getAllUserName();

        for(int i=0;i<userDtoList.size();i++){
            if(txtSearch.getText().equalsIgnoreCase(String.valueOf(userDtoList.get(i)))){
                ViewUserFormController.id= Integer.parseInt((txtSearch.getText()));
                Navigation.popupPane("ViewUserForm.fxml");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            getAllIds();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void getAllIds() {
        vBoxUserManage.getChildren();
        List<UserDto> userList=null;
        userList=userService.getAllUserId();
        for(int i=0;i<userList.size();i++){
            loadTableData(userList.get(i).getId());
        }
    }

    private void loadTableData(int id) {
        try{
            FXMLLoader loader=new FXMLLoader(UserFormController.class.getResource("/view/UserBarForm.fxml"));
            Parent root=loader.load();
            UserBarFormController controller=loader.getController();
            controller.setData(id);
            vBoxUserManage.getChildren().add(root);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
