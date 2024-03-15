package lk.ijse.library.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;
import lk.ijse.library.util.DateTimeUtil;

public class ReturnAddToCartBarFormController {

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

    public void setData(int id) {
        try {
            BookDto bookDto= transactionService.getDtodata(id);
            txtTransactionId.setText(String.valueOf(1));
            txtId.setText(bookDto.getTitle());
            txtBorrowDate.setText(DateTimeUtil.dateNow());
            txtReturnDate.setText(DateTimeUtil.dateNow());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
