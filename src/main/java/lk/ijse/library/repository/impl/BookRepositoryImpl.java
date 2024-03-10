package lk.ijse.library.repository.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.entity.Book;
import lk.ijse.library.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public Book get(String id) {
        try{
            Book book=session.get(Book.class,id);
            return book;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public void setSession(Session session) {
    this.session=session;
    }
}


