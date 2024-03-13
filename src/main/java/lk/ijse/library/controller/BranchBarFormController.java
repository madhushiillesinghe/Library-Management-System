package lk.ijse.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.library.dto.BranchDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.BranchService;
import lk.ijse.library.service.impl.BranchServiceImpl;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class BranchBarFormController {

    @FXML
    private Text txtBookCount;

    @FXML
    private Text txtBranch;

    @FXML
    private Text txtHead;

    @FXML
    private Text txtId;
    BranchService branchService= (BranchService) BoFactory.getBoFactory().getBo(BoFactory.BOType.BRANCH);

    @FXML
    void deleteMouseClick(MouseEvent event) {
        try {
            int id= Integer.parseInt(txtId.getText());
            BranchDto branchDto =branchService.getDtodata(id);
            boolean isDeleted =branchService.deleteBranch(branchDto);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Branch deleted").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void updateMouseClick(MouseEvent event) throws IOException {
        UpdateBrachFormController.setId(Integer.parseInt((txtId.getText())));
        Navigation.popupPane("UpdateBrachForm.fxml");
    }
    public void setData(int id) {
        BranchDto branches=null;
        try {
            branches= branchService.getDtodata(id);
            this.txtId.setText(String.valueOf(branches.getId()));
            txtBranch.setText(branches.getLocation());
            txtHead.setText(branches.getHead_Name());
            txtBookCount.setText(String.valueOf(branches.getBookTotal()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
