package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.entity.Book;
import lk.ijse.library.repository.BookRepository;
import lk.ijse.library.repository.impl.BookRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookServiceImpl {
    private static Session session;
    private final BookRepositoryImpl bookRepository;
    private static BookServiceImpl bookService;

    private BookServiceImpl() {
        bookRepository = BookRepositoryImpl.getInstance();
        session= PropertiesConfig.getInstance().getSession();
    }
    public static BookServiceImpl getInstance() {
        return null ==bookService
                ? bookService = new BookServiceImpl()
                : bookService;
    }
    public static boolean saveBook(BookDto bookDto){
        session= PropertiesConfig.getInstance().getSession();
          Transaction transaction=session.beginTransaction();
        try{
            Book bookEntity= (Book) session.save(bookDto.toEntity());
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }

    }
}
