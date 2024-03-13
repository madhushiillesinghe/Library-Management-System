package lk.ijse.library.repository.impl;

import lk.ijse.library.entity.Transaction;
import lk.ijse.library.repository.DAOFactory;
import lk.ijse.library.repository.TransactionRepository;
import org.hibernate.Session;

public class TransactionRepositoryImpl implements TransactionRepository {
    private Session session;
    private static TransactionRepositoryImpl transactionRepository;
    public TransactionRepositoryImpl() {
    }
    public static TransactionRepositoryImpl getInstance() {
        return null == transactionRepository
                ? transactionRepository = (TransactionRepositoryImpl) DAOFactory.getDADFactory().getDao(DAOFactory.DAOType.TRANSACTION)
                : transactionRepository;
    }


    @Override
    public boolean save(Transaction entity) {
        session.save(entity);
        return true;
    }

    @Override
    public boolean update(Transaction entity) {
        session.update(entity);
        return true;
    }

    @Override
    public Transaction getId(int id) {
        Transaction transaction=session.get(Transaction.class,id);
        return transaction;
    }

    @Override
    public Transaction getName(String name) {
        Transaction transaction=session.get(Transaction.class,name);
        return transaction;
    }

    @Override
    public boolean delete(Transaction entity) {
       session.delete(entity);
       return true;
    }

    @Override
    public void setSession(Session session) {
    this.session=session;
    }
}
