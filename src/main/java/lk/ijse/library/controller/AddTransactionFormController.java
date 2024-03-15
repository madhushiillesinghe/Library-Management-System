

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
import lk.ijse.library.entity.TransactionDetail;
import lk.ijse.library.entity.Users;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;
import lk.ijse.library.service.impl.TransactionServiceImpl;
import lk.ijse.library.util.DateTimeUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.*;

public class AddTransactionFormController implements Initializable {

    public static Users user;
    public static BookDto book;
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
     List<BookDto> bookDtoList=new ArrayList<>();
    List<TransactionDetailDto> transactionDetails=new ArrayList<>();


    TransactionService transactionService= (TransactionService) BoFactory.getBoFactory().getBo(BoFactory.BOType.TRANSACTION);

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        clearTextField();
        String bookName=cmbBookName.getSelectionModel().getSelectedItem();
        bookList.add(bookName);
        BookDto bookDto=transactionService.getData(cmbBookName.getSelectionModel().getSelectedItem());
        if(bookDto.getStatus().equalsIgnoreCase("Available")) {
            bookDto.setStatus("not Available");
            bookDtoList.add(bookDto);

        }else {
            new Alert(Alert.AlertType.ERROR, "This Book is not available").show();
        }
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


        transactionDto.setStatus("borrow");
        transactionDto.setReturnDate(DateTimeUtil.dateReturn());
        transactionDto.setUsers(UserLoginFormController.userDto);


        BookDto bookDto=transactionService.getData(cmbBookName.getSelectionModel().getSelectedItem());
        bookDto.setStatus("not Available");

        TransactionDetailDto transactionDetailDto1=new TransactionDetailDto();
        transactionDetailDto1.setTransaction(transactionDto);
        transactionDetailDto1.setBook(bookDto);

        transactionDetails.add(transactionDetailDto1);

        transactionDetailDto.setTransaction(transactionDto);
        transactionDetailDto.setBook(bookDto);


        System.out.println("drf"+transactionDetails);
        boolean isSaved=transactionService.saveUserBookBorrow(transactionDto,bookDtoList);
        if(isSaved){
            System.out.println("Book Borrow transaction saved ");
            new Alert(Alert.AlertType.CONFIRMATION,"Book Borrowed Success").show();
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
