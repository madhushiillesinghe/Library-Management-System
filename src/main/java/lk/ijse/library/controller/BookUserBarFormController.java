package lk.ijse.library.controller;

import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.service.BookService;
import lk.ijse.library.service.impl.BookServiceImpl;
import lk.ijse.library.util.Navigation;

import java.io.IOException;

public class BookUserBarFormController {

    @FXML
    private Text txtAvailability;

    @FXML
    private Text txtGerne;

    @FXML
    private Text txtId;

    @FXML
    private Text txtName;
    BookService bookService=new BookServiceImpl();

    @FXML
    void ViewBookOnMouseClick(MouseEvent event) throws IOException {
        ViewBookFormController.setId(Integer.parseInt((txtId.getText())));
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
