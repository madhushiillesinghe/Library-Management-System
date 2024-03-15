package lk.ijse.library.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.TransactionDetailDto;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateTransactionFormController implements Initializable {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnReturn;

    @FXML
    private ComboBox<Integer> cmbBorrowBook;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblBookGenre;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBookName;

    @FXML
    private Label lblBorrowDate;

    @FXML
    private Label lblReturnDate;

    @FXML
    private VBox vBoxUpdateTransaction;
    public static int id;

    TransactionService transactionService= (TransactionService) BoFactory.getBoFactory().getBo(BoFactory.BOType.TRANSACTION);


    public static void setId(int id) {
UpdateTransactionFormController.id=id;    }

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnOnAction(ActionEvent event) {

    }

    @FXML
    void cmbOnAction(ActionEvent event) {
    setData();
        TransactionDto transactionDto=transactionService.getDtoData(id);
        lblBorrowDate.setText(String.valueOf(transactionDto.getBorrowDate()));
        lblReturnDate.setText(transactionDto.getReturnDate());

    }

    private void setData() {
        int id=cmbBorrowBook.getSelectionModel().getSelectedItem();
        BookDto book= null;
        try {
            book= transactionService.getDtodata(id);
           lblBookId.setText(String.valueOf(id));
           lblAuthor.setText(book.getAuthor());
           lblBookGenre.setText(book.getGenre());
           lblBookName.setText(book.getTitle());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCmbData();
    }

    private void setCmbData() {
        ObservableList<Integer> obList = FXCollections.observableArrayList();
        cmbBorrowBook.setItems(obList);
        try{
            List<Integer> bookIds=transactionService.getTransactionDetail(id);
            for (Integer id:bookIds){
                obList.add(id);
            }

        }catch (Exception e){
        e.printStackTrace();
    }
    }


}
