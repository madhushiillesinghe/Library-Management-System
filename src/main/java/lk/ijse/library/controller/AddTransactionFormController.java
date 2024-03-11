package lk.ijse.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import lk.ijse.library.dto.BookDto;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTransactionFormController implements Initializable {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnBorrow;

    @FXML
    private ComboBox<?> cmbBookName;

    @FXML
    private Label lblAuthor;

    @FXML
    private Label lblBookGenre;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblBookName;



    @FXML
    private VBox vBoxBookManage;

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

    }

    @FXML
    void cmbOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
    }

    private void setData() {
       /* BookDto book= null;
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
        }*/
    }
}
