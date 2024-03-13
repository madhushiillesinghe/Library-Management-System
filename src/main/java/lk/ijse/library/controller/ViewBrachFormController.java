package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.BranchDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.BookService;
import lk.ijse.library.service.BranchService;
import lk.ijse.library.service.impl.BookServiceImpl;
import lk.ijse.library.service.impl.BranchServiceImpl;
import lk.ijse.library.util.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewBrachFormController implements Initializable {
    public static int id;

    @FXML
    private Button btnCancel;

    @FXML
    private Label lblBookTotal;

    @FXML
    private Label lblBranchhead;

    @FXML
    private Label lblId;

    @FXML
    private Label lblLocation;
    BranchService branchService= (BranchService) BoFactory.getBoFactory().getBo(BoFactory.BOType.BRANCH);
    public static void setId(int id) {
        ViewBrachFormController.id=id;

    }
    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePane();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }

    private void setData() {
        try{

            BranchDto branchDto=branchService.getData(id);
            lblBranchhead.setText(branchDto.getHead_Name());
            lblId.setText(String.valueOf(branchDto.getId()));
            lblLocation.setText(branchDto.getLocation());
            lblBookTotal.setText(String.valueOf(branchDto.getBookTotal()));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
