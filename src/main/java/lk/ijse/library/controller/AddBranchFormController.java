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
import lk.ijse.library.service.BranchService;
import lk.ijse.library.service.impl.BranchServiceImpl;
import lk.ijse.library.util.Navigation;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AddBranchFormController implements Initializable {


    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancel;


    @FXML
    private ComboBox<String> ranchLocation;

    @FXML
    private TextField txtBookCount;

    @FXML
    private TextField txtBrachId;

    @FXML
    private TextField txtBranchHead;
    BranchService branchService=new BranchServiceImpl();


    @FXML
    void btnAddOnAction(ActionEvent event) {
        BranchDto branchDto=new BranchDto();

        branchDto.setId(Integer.parseInt(txtBrachId.getText()));
        branchDto.setLocation(ranchLocation.getSelectionModel().getSelectedItem());
        branchDto.setBookTotal(Integer.parseInt(txtBookCount.getText()));
        branchDto.setHead_Name(txtBranchHead.getText());
        branchDto.setAdmin(LoginFormController.adminDto.toEntity());

        try{
            boolean branchIsSaved;
            branchIsSaved= branchService.saveBranch(branchDto);
            if((branchIsSaved)){
                new Alert(Alert.AlertType.CONFIRMATION, "Branch saved!").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();


        }
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePane();
    }


    @FXML
    void cmbLocationOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    setLocation();
    }

    private void setLocation() {
        ArrayList<String> type=new ArrayList<>();
        type.add("Galle");
        type.add("Mathara");
        type.add("Colombo ");
        type.add("Kandy");
        ranchLocation.getItems().addAll(type);
    }
    }

