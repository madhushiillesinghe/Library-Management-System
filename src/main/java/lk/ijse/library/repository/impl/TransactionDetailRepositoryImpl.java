package lk.ijse.library.repository.impl;

import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Transaction;
import lk.ijse.library.entity.TransactionDetail;
import lk.ijse.library.repository.SuperRepository;
import lk.ijse.library.repository.TransactionDetailRepository;
import org.hibernate.Session;

public class TransactionDetailRepositoryImpl implements TransactionDetailRepository, SuperRepository {
    private Session session;
    private static TransactionDetailRepositoryImpl transactionRepository;

    public TransactionDetailRepositoryImpl() {
    }

    public static TransactionDetailRepositoryImpl getInstance() {
        return null == transactionRepository
                ? transactionRepository = new TransactionDetailRepositoryImpl()
                : transactionRepository;
    }
    @Override
    public boolean saveTransactinDetail(TransactionDetail transactionDetail) {
        session.save(transactionDetail);
        return false;
    }

    @Override
    public void setSession(Session session) {
        session=this.session;
    }
}
