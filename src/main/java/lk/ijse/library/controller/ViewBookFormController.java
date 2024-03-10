package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.service.BookService;
import lk.ijse.library.service.impl.BookServiceImpl;
import lk.ijse.library.util.Navigation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewBookFormController implements Initializable {


    public static int id;
    @FXML
    private Button btnCancel;

    @FXML
    private Label lblAdminId;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblBookCount;

    @FXML
    private Label lblBookGenre;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBookName;
    BookService bookService=new BookServiceImpl();


    public static void setId(int id) {
        ViewBookFormController.id=id;

    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Navigation.adminClosePane();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
setData();
    }
    private void setData() {
        try{
            BookDto bookDto= bookService.getData((id));
            System.out.println("book dto "+bookDto);
            lblAuthor.setText(bookDto.getAuthor());
            lblBookCount.setText(String.valueOf(bookDto.getCount()));
            lblBookId.setText(String.valueOf(bookDto.getId()));
            lblBookGenre.setText(bookDto.getGenre());
            lblBookName.setText(bookDto.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
