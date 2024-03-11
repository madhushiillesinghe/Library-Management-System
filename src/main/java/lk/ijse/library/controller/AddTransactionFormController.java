package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.service.TransactionService;
import lk.ijse.library.service.impl.TransactionServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTransactionFormController implements Initializable {

    public static int id;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnBorrow;

    @FXML
    private ComboBox<?> cmbBookName;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblBookGenre;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBookName;

    @FXML
    private VBox vBoxBookManage;

    TransactionService transactionService=new TransactionServiceImpl();

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

    }

    @FXML
    void cmbOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }

    private void setData() {
        BookDto book= null;
        try {
            book= transactionService.getDtodata(id);
            this.lblBookId.setText(String.valueOf(book.getId()));
            lblBookName.setText(book.getTitle());
            lblBookGenre.setText(book.getGenre());
            lblAuthor.setText(book.getAuthor());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
