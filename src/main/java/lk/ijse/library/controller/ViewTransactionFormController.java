package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.TransactionDetailDto;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewTransactionFormController implements Initializable {


    @FXML
    private Button btnCancel;

    @FXML
    private Button btnReturn;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBookName;

    @FXML
    private Label lblBorrowDate;

    @FXML
    private Label lblReturnDate;
    public static int id;

    public static void setId(int id){
        ViewTransactionFormController.id = id;
    }
    TransactionService transactionService= (TransactionService) BoFactory.getBoFactory().getBo(BoFactory.BOType.TRANSACTION);


    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }

    private void setData() {
        try{
            TransactionDto transactionDto=transactionService.getDtoData(ViewTransactionFormController.id);
            lblBorrowDate.setText(String.valueOf(transactionDto.getBorrowDate()));
            lblReturnDate.setText(transactionDto.getReturnDate());
            BookDto bookDto=new BookDto();
           List<Integer> bookId =transactionService.getTransactionDetail(ViewTransactionFormController.id);
            for(Integer bookid:bookId){
              bookDto=transactionService.getDtodata(bookid);
            }
           lblBookId.setText(String.valueOf((bookId.get(0))));
            lblBookName.setText(bookDto.getTitle());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
