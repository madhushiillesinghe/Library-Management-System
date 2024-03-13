package lk.ijse.library.dto;

import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Transaction;
import lk.ijse.library.entity.TransactionDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDetailDto {
    private TransactionDto transaction;
    private BookDto book;

    public TransactionDetail toEntity(){
        TransactionDetail transactionDetail=new TransactionDetail();
        transactionDetail.setBook(this.book.toEntity());
        transactionDetail.setTransaction(this.transaction.toEntity());
        return transactionDetail;
    }
}
