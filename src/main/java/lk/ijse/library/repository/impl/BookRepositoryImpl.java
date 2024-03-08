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
       session.save(entity);
       return true;
    }

    @Override
    public boolean update(Book dto) {
        return false;
    }

    @Override
    public Book get(String id) {
        return null;
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


