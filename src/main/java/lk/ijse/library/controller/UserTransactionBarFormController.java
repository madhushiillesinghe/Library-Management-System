package lk.ijse.library.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;

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
    void updateMouseClick(MouseEvent event) {

    }

    @FXML
    void viewMouseClick(MouseEvent event) {

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
