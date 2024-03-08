package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.entity.Book;
import lk.ijse.library.service.impl.BookServiceImpl;
import lk.ijse.library.util.Navigation;

import java.sql.SQLException;

public class AddBookFormController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<?> cmbAdminId;

    @FXML
    private ComboBox<?> cmbBookGenre;

    @FXML
    private TextField txtBookAuthor;

    @FXML
    private TextField txtBookCount;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookName;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        BookDto bookDto=new BookDto();
        bookDto.setId(txtBookId.getText());
        bookDto.setAuthor(txtBookAuthor.getText());
        bookDto.setCount(Integer.parseInt(txtBookCount.getText()));
        bookDto.setTitle(txtBookName.getText());
        bookDto.setGenre((String) cmbBookGenre.getSelectionModel().getSelectedItem());
        try{
boolean bookIsSaved;
bookIsSaved= BookServiceImpl.saveBook(bookDto);
if(bookIsSaved){
    new Alert(Alert.AlertType.CONFIRMATION, "Book saved!").show();
}
    }catch (Exception e){
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();


    }
    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePane();
    }

    @FXML
    void cmbAdminIdOnAction(ActionEvent event) {

    }

    @FXML
    void cmbBookGenre(ActionEvent event) {

    }

}
