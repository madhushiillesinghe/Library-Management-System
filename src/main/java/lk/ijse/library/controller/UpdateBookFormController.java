package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.entity.Book;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.BookService;
import lk.ijse.library.service.impl.BookServiceImpl;
import lk.ijse.library.util.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateBookFormController implements Initializable {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnUpdate;



    @FXML
    private ComboBox<String> cmbBookGenre;

    @FXML
    private TextField txtBookAuthor;

    @FXML
    private TextField txtBookCount;

    @FXML
    private  TextField txtBookId;

    @FXML
    private TextField txtBookName;

    BookService bookService= (BookService) BoFactory.getBoFactory().getBo(BoFactory.BOType.BOOK);
    public static int id;

    public static void setId(int id){
        UpdateBookFormController.id = id;
    }


    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePane();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        BookDto bookDto=new BookDto();
        BookDto bookDto1=bookService.getDtodata(Integer.parseInt(txtBookId.getText()));
        bookDto.setId(Integer.parseInt(txtBookId.getText()));
        bookDto.setAuthor(txtBookAuthor.getText());
        bookDto.setTitle(txtBookName.getText());
        bookDto.setStatus(bookDto1.getStatus());
        bookDto.setGenre( cmbBookGenre.getSelectionModel().getSelectedItem());
        bookDto.setAdmin(LoginFormController.adminDto);

        try{
            boolean bookIsUpdated;
            bookIsUpdated= bookService.updateBook(bookDto);
            if(bookIsUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Book Updated!").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();


        }
    }
    @FXML
    void cmbBookGenre(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setGenre();
        setData();
    }
    private void setGenre() {
        ArrayList<String> type=new ArrayList<>();
        type.add("Novel");
        type.add("Short Story");
        type.add("detactive ");
        type.add("child book");
        cmbBookGenre.getItems().addAll(type);
    }
    public void setData() {
        try{
            BookDto bookDto=bookService.getDtodata(UpdateBookFormController.id);
            txtBookAuthor.setText(bookDto.getAuthor());
            txtBookName.setText(bookDto.getTitle());
            txtBookId.setText(String.valueOf(bookDto.getId()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
