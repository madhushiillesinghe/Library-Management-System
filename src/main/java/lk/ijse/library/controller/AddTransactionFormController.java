

package lk.ijse.library.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.service.TransactionService;
import lk.ijse.library.service.impl.TransactionServiceImpl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddTransactionFormController implements Initializable {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnBorrow;

    @FXML
    private ComboBox<String> cmbBookName;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookGenre;

    @FXML
    private TextField txtBookName;

    @FXML
    private TextField txtId;

    @FXML
    private VBox vBoxBookManage;
    public static int id;
    TransactionService transactionService=new TransactionServiceImpl();

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        txtBookGenre.clear();
        txtAuthor.clear();
        txtId.clear();
        txtBookName.clear();
    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

    }

    @FXML
    void cmbOnAction(ActionEvent event) {
        txtBookGenre.clear();
        txtAuthor.clear();
        txtId.clear();
        txtBookName.clear();
        setCmbBoxDetail();

    }

    private void setCmbBoxDetail() {
        BookDto book= null;
        try {
            book= transactionService.getData(cmbBookName.getSelectionModel().getSelectedItem());
            this.txtId.setText(String.valueOf(book.getId()));
            txtBookName.setText(book.getTitle());
            txtBookGenre.setText(book.getGenre());
            txtAuthor.setText(book.getAuthor());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setData() {
        BookDto book= null;
        try {
            book= transactionService.getDtodata(id);
            this.txtId.setText(String.valueOf(book.getId()));
            txtBookName.setText(book.getTitle());
            txtBookGenre.setText(book.getGenre());
            txtAuthor.setText(book.getAuthor());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void loadBookName() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        cmbBookName.setItems(obList);

        try{
            List<String> bookList =transactionService.getAllBookTitle();
            for (String title: bookList) {
                obList.add(title);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
        loadBookName();
    }

}
