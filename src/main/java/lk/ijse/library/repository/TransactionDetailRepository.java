package lk.ijse.library.repository;

import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Transaction;
import lk.ijse.library.entity.TransactionDetail;
import org.hibernate.Session;

public interface TransactionDetailRepository {
    boolean saveTransactinDetail(TransactionDetail transactionDetail);

    void setSession(Session session);
}
