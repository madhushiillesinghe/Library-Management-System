package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.BranchDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.BookService;
import lk.ijse.library.service.BranchService;
import lk.ijse.library.service.impl.BookServiceImpl;
import lk.ijse.library.service.impl.BranchServiceImpl;
import lk.ijse.library.util.Navigation;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateBrachFormController implements Initializable {
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmblocation;

    @FXML
    private TextField txtBookCount;

    @FXML
    private TextField txtBrachId;

    @FXML
    private TextField txtBranchHead;
    BranchService branchService= (BranchService) BoFactory.getBoFactory().getBo(BoFactory.BOType.BRANCH);
    public static int id;

    public static void setId(int id) {
        UpdateBrachFormController.id=id;
    }


    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePane();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        BranchDto branchDto=new BranchDto();

        branchDto.setId(Integer.parseInt(txtBrachId.getText()));
        branchDto.setLocation(cmblocation.getSelectionModel().getSelectedItem());
        branchDto.setBookTotal(Integer.parseInt(txtBookCount.getText()));
        branchDto.setHead_Name(txtBranchHead.getText());
        branchDto.setAdmin(LoginFormController.adminDto);

        try{
            boolean branchIsUpdated;
            branchIsUpdated= branchService.updateBranch(branchDto);
            if((branchIsUpdated)){
                new Alert(Alert.AlertType.CONFIRMATION, "Branch update!").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }
    }

    @FXML
    void cmbLocationOnAction(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setLocation();
        setData();
    }

    private void setData() {
        try{
            BranchDto branchDto=branchService.getDtodata(UpdateBrachFormController.id);
            txtBookCount.setText(String.valueOf(branchDto.getBookTotal()));
            txtBrachId.setText(String.valueOf(branchDto.getId()));
            txtBranchHead.setText(branchDto.getHead_Name());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setLocation() {
        ArrayList<String> type=new ArrayList<>();
        type.add("Galle");
        type.add("Mathara");
        type.add("Colombo ");
        type.add("Kandy");
        cmblocation.getItems().addAll(type);
    }
}
