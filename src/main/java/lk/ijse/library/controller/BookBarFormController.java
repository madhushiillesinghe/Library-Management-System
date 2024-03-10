
package lk.ijse.library.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.library.entity.Book;
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
    BookServiceImpl bookService=new BookServiceImpl();


    @FXML
    void deleteMouseClick(MouseEvent event) {

    }

    @FXML
    void updateMouseClick(MouseEvent event) throws IOException {
        UpdateBookFormController.setId(Integer.parseInt((txtId.getText())));
        Navigation.popupPane("UpdateBookForm.fxml");

    }
    public void setData(int id) {
        Book book= null;
        try {
            book= bookService.getData(id);
            this.txtId.setText(String.valueOf(book.getId()));
            txtName.setText(book.getTitle());
            txtCount.setText(String.valueOf(book.getCount()));
            txtGenre.setText(book.getGenre());
            if(book.getCount()>0) {
                txtAvailability.setText("Available");
            }else {
                txtAvailability.setText("not available");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
