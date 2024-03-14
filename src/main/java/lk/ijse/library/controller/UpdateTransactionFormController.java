package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;
import lk.ijse.library.util.DateTimeUtil;
import lk.ijse.library.util.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateTransactionFormController implements Initializable {

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
        UpdateTransactionFormController.id = id;
    }

    TransactionService transactionService= (TransactionService) BoFactory.getBoFactory().getBo(BoFactory.BOType.TRANSACTION);

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePaneUser();
    }

    @FXML
    void btnReturnOnAction(ActionEvent event) {
        TransactionDto transactionDto=new TransactionDto();

        transactionDto.setStatus("return");
        transactionDto.setReturnDate(DateTimeUtil.dateReturn());
        transactionDto.setUsers(UserLoginFormController.userDto);

        BookDto bookDto=new BookDto();

        boolean isSaved=transactionService.UpdateUserReturnBook(transactionDto,bookDto);
        if(isSaved){
            System.out.println("Book Borrow transaction saved ");
            new Alert(Alert.AlertType.CONFIRMATION,"Book Borrowed Success").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Unable to Save the TRANSACtion!!!").show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
          }

    private void setData() {
        try{
            TransactionDto transactionDto=transactionService.getDtoData(UpdateTransactionFormController.id);
            lblBorrowDate.setText(String.valueOf(transactionDto.getBorrowDate()));
            lblReturnDate.setText(transactionDto.getReturnDate());
           /* TransactionDetailDto transactionDetailDto=transactionService.getTransactionDetail(ViewTransactionFormController.id);
            System.out.println("trnss "+transactionDetailDto);*/
           /* lblBookId.setText(String.valueOf(transactionDetailDto.getBook().getId()));
            lblBookName.setText(transactionDetailDto.getBook().getTitle());*/
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
