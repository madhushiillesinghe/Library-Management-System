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
        try{
            session.save(entity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(Book entity) {
        try{
            session.update(entity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Book getId(int id) {
        try{
            Book book=session.get(Book.class,id);
            return book;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Book getName(String name) {
        try{
            Book book=session.get(Book.class,name);
            return book;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(Book entity) {
        try{
            session.delete(entity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    @Override
    public List<Book> getAllBookId() {
        List<Book> bookIds = new ArrayList<>();
        try {
            Query<Book> query = session.createQuery("SELECT i FROM  lk.ijse.library.entity.Book i", Book.class);
            bookIds = query.getResultList();
            return bookIds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Integer> getAllBookName() {

        try {
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
            System.out.println(bookList);
            for(int i=0;i<bookList.size();i++){
                bookIds.add(bookList.get(i).getId());
            }

            System.out.println(bookIds);
            return bookIds;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

           /* Query<String> query=session.createQuery("SELECT i FROM lk.ijse.library.entity.Book i");
            bookname=query.getResultList();
            return  bookname;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }*/

    }

    @Override
    public void setSession(Session session) {
    this.session=session;
    }
}


