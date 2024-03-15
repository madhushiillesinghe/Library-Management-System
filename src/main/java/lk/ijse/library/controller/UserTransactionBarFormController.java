package lk.ijse.library.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class UserTransactionBarFormController {

    public static int id;
    @FXML
    private Text txtBookId;

    @FXML
    private Text txtBorrowDate;

    @FXML
    private Text txtReturnDate;

    @FXML
    private Text txtStatus;

    @FXML
    private Text txtTransactionId;
    TransactionService transactionService= (TransactionService) BoFactory.getBoFactory().getBo(BoFactory.BOType.TRANSACTION);

    @FXML
    void updateMouseClick(MouseEvent event) throws IOException {
       UpdateTransactionFormController.setId(Integer.parseInt(txtTransactionId.getText()));
        Navigation.switchPagingUser(UserGlobalFormController.getInstance().paneId,"UpdateTransactionForm.fxml");
    }

    @FXML
    void viewMouseClick(MouseEvent event) throws IOException {
        ViewTransactionFormController.setId(Integer.parseInt(txtTransactionId.getText()));
        Navigation.popupPaneUser("ViewTransactionForm.fxml");
    }

    public void setData(int id) {
        TransactionDto transactionDto=null;
        try{
            transactionDto=transactionService.getDtoData(id);
            txtReturnDate.setText(transactionDto.getReturnDate());
            txtStatus.setText(transactionDto.getStatus());
            txtBorrowDate.setText(String.valueOf(transactionDto.getBorrowDate()));
            txtTransactionId.setText(String.valueOf(transactionDto.getId()));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
