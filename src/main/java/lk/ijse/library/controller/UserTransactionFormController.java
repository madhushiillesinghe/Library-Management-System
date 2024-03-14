package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.entity.Transaction;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserTransactionFormController implements Initializable {

    public static int id;
    @FXML
    private TextField txtSearch;

    @FXML
    private VBox vBoxTransactionManage;
    private static UserTransactionFormController controller;
    public UserTransactionFormController(){
        controller=this;
    }
    public static UserTransactionFormController getInstance(){
        return controller;
    }
    TransactionService transactionService= (TransactionService) BoFactory.getBoFactory().getBo(BoFactory.BOType.TRANSACTION);

    @FXML
    void btnSearchOnAction(ActionEvent event) {

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
        vBoxTransactionManage.getChildren();
        List<TransactionDto> transactionDtoList=null;
        transactionDtoList=transactionService.getSomeTransactionId(id);
        for(int i=0;i<transactionDtoList.size();i++){
            loadTableData(transactionDtoList.get(i).getId());
        }
    }

    private void loadTableData(int id) {
        try{
            FXMLLoader loader=new FXMLLoader(UserTransactionFormController.class.getResource("/view/UserTransactionBarForm.fxml"));
            Parent root=loader.load();
            UserTransactionBarFormController controller=loader.getController();
            controller.setData(id);
            vBoxTransactionManage.getChildren().add(root);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
