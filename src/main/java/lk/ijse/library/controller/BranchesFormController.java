package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lk.ijse.library.dto.BranchDto;
import lk.ijse.library.service.BranchService;
import lk.ijse.library.service.impl.BranchServiceImpl;
import lk.ijse.library.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BranchesFormController implements Initializable {

    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxBrachesManage;
   BranchService branchService=new BranchServiceImpl();
    private static BranchesFormController controller;
    public BranchesFormController(){
        controller=this;
    }
    public static BranchesFormController getInstance(){
        return controller;
    }
    @FXML
    void btnAddBraches(ActionEvent event) throws IOException {
        Navigation.popupPane("AddBranchForm.fxml");
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws IOException {
        List<Integer> branchDtoList=branchService.getAllBranchIds();

        for(int i=0;i<branchDtoList.size();i++){
            if(txtSearch.getText().equalsIgnoreCase(String.valueOf(branchDtoList.get(i)))){
                ViewBrachFormController.id= Integer.parseInt((txtSearch.getText()));
                Navigation.popupPane("ViewBrachForm.fxml");
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
        vBoxBrachesManage.getChildren();
        List<BranchDto> branchList=null;
        branchList=branchService.getAllBranchId();
        for(int i=0;i<branchList.size();i++){
            loadTableData(branchList.get(i).getId());
        }
    }

    private void loadTableData(int id) {
        try{
            FXMLLoader loader=new FXMLLoader(BranchesFormController.class.getResource("/view/BranchBarForm.fxml"));
            Parent root=loader.load();
            BranchBarFormController controller=loader.getController();
            controller.setData(id);
            vBoxBrachesManage.getChildren().add(root);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
