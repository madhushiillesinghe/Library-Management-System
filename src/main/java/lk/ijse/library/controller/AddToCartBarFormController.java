package lk.ijse.library.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;
import lk.ijse.library.service.impl.TransactionServiceImpl;
import lk.ijse.library.util.DateTimeUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class AddToCartBarFormController implements Initializable {

    @FXML
    private Text txtBorrowDate;

    @FXML
    private Text txtId;

    @FXML
    private Text txtReturnDate;

    @FXML
    private Text txtTransactionId;
    TransactionService transactionService= (TransactionService) BoFactory.getBoFactory().getBo(BoFactory.BOType.TRANSACTION);

    @FXML
    void deleteOnMouseClick(MouseEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setData(String id) {
        try {
           BookDto bookDto= transactionService.getData(id);
          txtTransactionId.setText(String.valueOf(1));
          txtId.setText(bookDto.getTitle());
          txtBorrowDate.setText(DateTimeUtil.dateNow());
          txtReturnDate.setText(DateTimeUtil.dateReturn());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
