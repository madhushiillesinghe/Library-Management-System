package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.entity.Admin;
import lk.ijse.library.service.AdminService;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.BookService;
import lk.ijse.library.service.impl.AdminServiceImpl;
import lk.ijse.library.service.impl.BookServiceImpl;
import lk.ijse.library.util.Navigation;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddBookFormController  implements Initializable {
    BookService bookService= (BookService) BoFactory.getBoFactory().getBo(BoFactory.BOType.BOOK);

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancel;

    @FXML
    private ComboBox<String> cmbBookGenre;

    @FXML
    private TextField txtBookAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookName;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        BookDto bookDto=new BookDto();

        bookDto.setId(Integer.parseInt(txtBookId.getText()));
        bookDto.setAuthor(txtBookAuthor.getText());
        bookDto.setTitle(txtBookName.getText());
        bookDto.setGenre( cmbBookGenre.getSelectionModel().getSelectedItem());

        bookDto.setStatus("Available");
        System.out.println("book status"+bookDto.getStatus());
        bookDto.setAdmin(LoginFormController.adminDto);

        try{
            boolean bookIsSaved;
            bookIsSaved= bookService.saveBook(bookDto);
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
    void cmbBookGenre(ActionEvent event) {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setGenre();
    }

    private void setGenre() {
        ArrayList<String> type=new ArrayList<>();
        type.add("Novel");
        type.add("Short Story");
        type.add("detactive ");
        type.add("child book");
        type.add("Educational");
        type.add("Historical");
        cmbBookGenre.getItems().addAll(type);
    }
}
