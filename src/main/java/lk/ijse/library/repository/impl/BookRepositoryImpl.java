package lk.ijse.library.repository.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookRepositoryImpl {
    private Session session;

    private static BookRepositoryImpl bookRepositoryimpl;
    public static BookRepositoryImpl getInstance() {
        return null == bookRepositoryimpl
                ? bookRepositoryimpl = new BookRepositoryImpl()
                : bookRepositoryimpl;
    }
    public  void setSession(Session session) {
        this.session = session;
    }

    public BookRepositoryImpl() {
    }
    public boolean saveBook(Book book){
        return (boolean) session.save(book);

    }

}


