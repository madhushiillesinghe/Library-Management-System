

package lk.ijse.library.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.service.TransactionService;
import lk.ijse.library.service.impl.TransactionServiceImpl;
import lk.ijse.library.util.DateTimeUtil;
import lk.ijse.library.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.*;

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
    private TextField txtBorrowDate;
    @FXML
    private TextField txtReturnDate;

    @FXML
    private VBox vBoxBookManage;
    public static int id;
    List<String> bookList=new ArrayList<>();
    TransactionService transactionService=new TransactionServiceImpl();

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        txtBookGenre.clear();
        txtAuthor.clear();
        txtId.clear();
        txtBookName.clear();
        txtBorrowDate.clear();
        txtReturnDate.clear();
        String bookName=cmbBookName.getSelectionModel().getSelectedItem();
        bookList.add(bookName);
        AllBookCartId();



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
        txtBorrowDate.setText(DateTimeUtil.dateNow());
        txtReturnDate.setText(DateTimeUtil.dateReturn());

    }

    private void AllBookCartId() {
         vBoxBookManage.getChildren().clear();
        for (int i = 0; i < bookList.size(); i++) {
            loadDataTable(bookList.get(i));
        }
    }

    private void loadDataTable(String id) {
        try {
            FXMLLoader loader = new FXMLLoader(AddTransactionFormController.class.getResource("/view/AddToCartBarForm.fxml"));
            Parent root = loader.load();
            AddToCartBarFormController controller = loader.getController();
            controller.setData(id);
            vBoxBookManage.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
