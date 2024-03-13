

package lk.ijse.library.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.TransactionDetailDto;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.entity.Users;
import lk.ijse.library.service.TransactionService;
import lk.ijse.library.service.impl.TransactionServiceImpl;
import lk.ijse.library.util.DateTimeUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.*;

public class AddTransactionFormController implements Initializable {

    public static Users user;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnBorrow;
    @FXML
    private TextField txtTransactionId;

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
        clearTextField();
        String bookName=cmbBookName.getSelectionModel().getSelectedItem();
        bookList.add(bookName);
        AllBookCartId();



    }

    private void clearTextField() {
        txtBookGenre.clear();
        txtAuthor.clear();
        txtId.clear();
        txtBookName.clear();
        txtBorrowDate.clear();
        txtReturnDate.clear();
    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {
        TransactionDetailDto transactionDetailDto=new TransactionDetailDto();
        TransactionDto transactionDto=new TransactionDto();

/*
        transactionDto.setId(Integer.parseInt(txtTransactionId.getText()));
*/
        transactionDto.setStatus("borrow");
        transactionDto.setReturnDate(txtReturnDate.getText());
       // transactionDto.setBorrowDate(Timestamp.valueOf(txtBorrowDate.getText()));
        transactionDto.setUsers(UserLoginFormController.userDto);
        transactionDto.setId(1);
        System.out.println("transactionn dto"+transactionDto);

        BookDto bookDto=transactionService.getData(cmbBookName.getSelectionModel().getSelectedItem());

        transactionDetailDto.setTransaction(transactionDto);
        transactionDetailDto.setBook(bookDto);

        boolean isSaved=transactionService.saveUserBookBorrow(transactionDto,bookList,transactionDetailDto);
        if(isSaved){
            System.out.println("Book Borrow transaction saved ");
        }else {
            new Alert(Alert.AlertType.ERROR, "Unable to Save the TRANSACtion!!!").show();
        }
    }

    @FXML
    void cmbOnAction(ActionEvent event) {
        clearTextField();
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
