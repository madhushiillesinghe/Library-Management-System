package lk.ijse.library.controller;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.BookService;
import lk.ijse.library.service.impl.BookServiceImpl;
import lk.ijse.library.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookUserBarFormController {

    @FXML
    private Text txtAvailability;

    @FXML
    private Text txtGerne;

    @FXML
    private Text txtId;

    @FXML
    private Text txtName;

    public static  int id;
    BookService bookService= (BookService) BoFactory.getBoFactory().getBo(BoFactory.BOType.BOOK);

    @FXML
    void ViewBookOnMouseClick(MouseEvent event) throws IOException {
        ViewBookFormController.setId(Integer.parseInt((txtId.getText())));
        AddTransactionFormController.id= Integer.parseInt(txtId.getText());
        Navigation.switchPagingUser(UserGlobalFormController.getInstance().paneId, "AddTransactionForm.fxml");
        System.out.println("view success");
    }
    public void setData(int id) {
        BookDto book= null;
        try {
            book= bookService.getDtodata(id);
            this.txtId.setText(String.valueOf(book.getId()));
            txtName.setText(book.getTitle());
            txtGerne.setText(book.getGenre());
            AddTransactionFormController.book=book;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
