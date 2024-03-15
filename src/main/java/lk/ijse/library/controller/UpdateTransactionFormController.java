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
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.TransactionDetailDto;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;
import lk.ijse.library.util.DateTimeUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
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
    List<BookDto> bookDtoList=new ArrayList<>();

    TransactionService transactionService= (TransactionService) BoFactory.getBoFactory().getBo(BoFactory.BOType.TRANSACTION);


    public static void setId(int id) {
        UpdateTransactionFormController.id=id;
    }

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        int bookId=cmbBorrowBook.getSelectionModel().getSelectedItem();
        BookDto bookDto=transactionService.getDtodata(bookId);
        bookDto.setStatus("Available");
        bookDtoList.add(bookDto);
        AllBookCartId();
    }

    private void AllBookCartId() {
        vBoxUpdateTransaction.getChildren().clear();
        for (int i = 0; i < bookDtoList.size(); i++) {
            loadDataTable(bookDtoList.get(i).getId());
        }
    }

    private void loadDataTable(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(UpdateTransactionFormController.class.getResource("/view/ReturnAddToCartBarForm.fxml"));
            Parent root = loader.load();
            ReturnAddToCartBarFormController controller = loader.getController();
            controller.setData(id);
            vBoxUpdateTransaction.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnReturnOnAction(ActionEvent event) {

        TransactionDto transactionDto=new TransactionDto();
        transactionDto.setId(id);
        transactionDto.setStatus("Return");
        transactionDto.setReturnDate(DateTimeUtil.dateReturn());
        transactionDto.setUsers(UserLoginFormController.userDto);
        transactionDto.setBorrowDate(Timestamp.valueOf(lblBorrowDate.getText()));


        BookDto bookDto=transactionService.getDtodata(cmbBorrowBook.getSelectionModel().getSelectedItem());
        bookDto.setStatus("Available");
        boolean isSaved=transactionService.UpdateUserReturnBook(transactionDto,bookDtoList);
        if(isSaved){
            System.out.println("Book Return transaction saved ");
            new Alert(Alert.AlertType.CONFIRMATION,"Book Returned Success").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Unable to update the TRANSACtion!!!").show();
        }
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
