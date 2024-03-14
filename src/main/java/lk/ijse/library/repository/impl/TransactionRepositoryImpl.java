package lk.ijse.library.repository.impl;

import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Transaction;
import lk.ijse.library.repository.DAOFactory;
import lk.ijse.library.repository.TransactionRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {
    private Session session;
    public TransactionRepositoryImpl() {
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

    @Override
    public List<Transaction> getAllTransactionId() {
        List<Transaction> transactionsIds = new ArrayList<>();

        Query<Transaction> query = session.createQuery("SELECT i FROM  lk.ijse.library.entity.Transaction i", Transaction.class);
        transactionsIds = query.getResultList();
        return transactionsIds;
    }
    @Override
    public List<Transaction> getSomeTransactionId(int id){
        List<Transaction> transactions=new ArrayList<>();
        String JPQLQuery="SELECT A FROM Transaction A " +
                "WHERE A.id=:id";
        Query query = session.createQuery(JPQLQuery)
                .setParameter("id",id);
        return query.getResultList();
    }
}
