package lk.ijse.library.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.repository.DAOFactory;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class TransactionBarFormController {

    @FXML
    private Text txtBorrowDate;

    @FXML
    private Text txtId;

    @FXML
    private Text txtStatus;

    @FXML
    private Text txtUserId;
    TransactionService transactionService= (TransactionService) BoFactory.getBoFactory().getBo(BoFactory.BOType.TRANSACTION);


    @FXML
    void viewOnMouseClick(MouseEvent event) throws IOException {
    }

    public void setData(int id) {
        TransactionDto transactionDto=null;
        try{
            transactionDto=transactionService.getDtoData(id);
            this.txtId.setText(String.valueOf(transactionDto.getId()));
            txtUserId.setText(String.valueOf(transactionDto.getUsers().getId()));
            txtStatus.setText(transactionDto.getStatus());
            txtBorrowDate.setText(String.valueOf(transactionDto.getBorrowDate()));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
