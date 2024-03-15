package lk.ijse.library.repository.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.entity.Admin;
import lk.ijse.library.entity.Book;
import lk.ijse.library.repository.BookRepository;
import lk.ijse.library.repository.DAOFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private Session session;
    public BookRepositoryImpl() {
    }



    @Override
    public boolean save(Book entity) {
            session.save(entity);
            return true;
    }

    @Override
    public boolean update(Book entity) {
            session.update(entity);
            return true;
    }

    @Override
    public boolean updateBorrowBook(Book entity,List<String>bookName) {
        boolean isUpdated=false;
        for (int i=0;i<bookName.size();i++){
            session.update(entity);
            isUpdated=true;
            System.out.println("is Updates repo"+isUpdated);
        }
        return isUpdated;
    }

    @Override
    public boolean UpdateTransactionBook(List<String> bookName) {

            String status="not available";
            String JPQLQuery="UPDATE Book A SET A.status = :status WHERE A.title = :bookName";

            for (int i = 0; i < bookName.size() ; i++) {
                Query query = session.createQuery(JPQLQuery)
                        .setParameter("bookName", bookName)
                        .setParameter("status",status);
                     Book book= (Book) query.getResultList();
            }
        return true;
    }

    @Override
    public Book getId(int id) {
            Book book=session.get(Book.class,id);
            return book;
    }

    @Override
    public Book getName(String name) {
            String JPQLQuery="SELECT A FROM Book A WHERE A.title=:name";

            Query query=session.createQuery(JPQLQuery)
                    .setParameter("name",name);
        return (Book) query.uniqueResult();

    }


    @Override
    public boolean delete(Book entity) {
            session.delete(entity);
            return true;
    }
    @Override
    public List<Book> getAllBookId() {
        List<Book> bookIds = new ArrayList<>();

            Query<Book> query = session.createQuery("SELECT i FROM  lk.ijse.library.entity.Book i", Book.class);
            bookIds = query.getResultList();
            return bookIds;
    }

    @Override
    public List<Integer> getAllBookIds() {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Book> criteriaQuery=builder.createQuery(Book.class);
            Root<Book> root=criteriaQuery.from(Book.class);
            criteriaQuery.select(root);

            List<Book> entities=session.createQuery(criteriaQuery).getResultList();
            List<Integer> bookIds=new ArrayList<>();
            List<Book>bookList=new ArrayList<>();
            for(int i=0;i<entities.size();i++){
                bookList.add(entities.get(i));
            }
            for(int i=0;i<bookList.size();i++){
                bookIds.add(bookList.get(i).getId());
            }
            return bookIds;
    }
@Override
    public List<String> getAllBookName() {
        String status="Available";
        String JPQLQuery="SELECT A.title FROM Book A WHERE A.status=:status";
       Query query=session.createQuery(JPQLQuery).setParameter("status",status);

       List<Object[]> list=query.list();
       ArrayList<Object> list2=new ArrayList<>();
       list2.addAll(list);

       List<String> bookName=new ArrayList<>();
       for(int i=0;i<list.size();i++){
           Object object=list2.get(i);
           String id= String.valueOf(object);
           bookName.add(id);
       }
       return bookName;
    }


    @Override
    public void setSession(Session session) {
    this.session=session;
    }
}


