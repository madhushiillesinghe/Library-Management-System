
package lk.ijse.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.BookService;
import lk.ijse.library.service.impl.BookServiceImpl;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class BookBarFormController {

    @FXML
    private Text txtAvailability;

    @FXML
    private Text txtCount;

    @FXML
    private Text txtGenre;

    @FXML
    private Text txtId;

    @FXML
    private Text txtName;
    BookService bookService= (BookService) BoFactory.getBoFactory().getBo(BoFactory.BOType.BOOK);


    @FXML
    void deleteMouseClick(MouseEvent event) {
        try {
            int id= Integer.parseInt(txtId.getText());
            BookDto bookDto=bookService.getDtodata(id);
            boolean isDeleted = bookService.deleteBook(bookDto);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Book deleted").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void updateMouseClick(MouseEvent event) throws IOException {
        UpdateBookFormController.setId(Integer.parseInt((txtId.getText())));
        Navigation.popupPane("UpdateBookForm.fxml");

    }
    public void setData(int id) {
        BookDto book= null;
        try {
            book= bookService.getDtodata(id);
            this.txtId.setText(String.valueOf(book.getId()));
            txtName.setText(book.getTitle());
            txtGenre.setText(book.getGenre());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
