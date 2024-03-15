package lk.ijse.library.repository.impl;

import lk.ijse.library.entity.Admin;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Transaction;
import lk.ijse.library.entity.TransactionDetail;
import lk.ijse.library.repository.DAOFactory;
import lk.ijse.library.repository.SuperRepository;
import lk.ijse.library.repository.TransactionDetailRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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
        String JPQLQuery="SELECT A FROM TransactionDetail A " +
                "WHERE A.transaction.id=:id";

        Query query = session.createQuery(JPQLQuery)
                .setParameter("id",id);
        return (TransactionDetail) query.uniqueResult();
    }

    public List<Integer> getAllBookId(int id) {
        String JPQLQuery="SELECT A.book.id FROM TransactionDetail A " +
                "WHERE A.transaction.id=:id";

        Query query = session.createQuery(JPQLQuery)
                .setParameter("id",id);
       return query.getResultList();
    }


    @Override
    public List<Integer> getAllBorrowBookIds(int id) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery=builder.createQuery(Integer.class);
        Root<TransactionDetail> root=criteriaQuery.from(TransactionDetail.class);
        criteriaQuery.select(root.get(String.valueOf(id)));

        criteriaQuery.where(builder.equal(root.get("transaction_id"),id));
        List<Integer> entities=session.createQuery(criteriaQuery).getResultList();
        List<Integer> bookIds=new ArrayList<>();
       // List<Book>bookList=new ArrayList<>();

        for(int i=0;i<entities.size();i++){
            bookIds.add(entities.get(i));
        }
        System.out.println("book ids"+bookIds);
        return bookIds;

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
