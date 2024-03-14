package lk.ijse.library.repository.impl;

import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Transaction;
import lk.ijse.library.entity.TransactionDetail;
import lk.ijse.library.repository.DAOFactory;
import lk.ijse.library.repository.SuperRepository;
import lk.ijse.library.repository.TransactionDetailRepository;
import org.hibernate.Session;

public class TransactionDetailRepositoryImpl implements TransactionDetailRepository{
    private Session session;

    public TransactionDetailRepositoryImpl() {
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public boolean save(TransactionDetail entity) {
        session.save(entity);
        return true;
    }

    @Override
    public boolean update(TransactionDetail entity) {
        return false;
    }

    @Override
    public TransactionDetail getId(int id) {
       TransactionDetail transactionDetail= session.get(TransactionDetail.class,id);
       return transactionDetail;

    }

    @Override
    public TransactionDetail getName(String name) {
        return null;
    }

    @Override
    public boolean delete(TransactionDetail dto) {
        return false;
    }
}
