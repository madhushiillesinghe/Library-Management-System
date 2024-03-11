package lk.ijse.library.repository;

import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Transaction;
import lk.ijse.library.entity.TransactionDetail;

public interface TransactionDetailRepository {
    boolean saveTransactinDetail(TransactionDetail transactionDetail);
}
