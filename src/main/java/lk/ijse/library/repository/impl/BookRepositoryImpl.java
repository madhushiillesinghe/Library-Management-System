package lk.ijse.library.repository.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.entity.Book;
import lk.ijse.library.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private Session session;
    private static BookRepositoryImpl bookRepositoryimpl;
    public BookRepositoryImpl() {
    }
    public static BookRepositoryImpl getInstance() {
        return null == bookRepositoryimpl
                ? bookRepositoryimpl = new BookRepositoryImpl()
                : bookRepositoryimpl;
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
    public Book getId(int id) {
            Book book=session.get(Book.class,id);
            return book;
    }

    @Override
    public Book getName(String name) {
            Book book=session.get(Book.class,name);
            return book;
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
    public void setSession(Session session) {
    this.session=session;
    }
}


