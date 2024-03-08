package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.repository.BookRepository;
import lk.ijse.library.repository.impl.BookRepositoryImpl;
import lk.ijse.library.service.BookService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookServiceImpl implements BookService {

    private  Session session;
    private final BookRepository bookRepository;
    private static BookService bookService;

    public BookServiceImpl() {
        bookRepository = BookRepositoryImpl.getInstance();
    }
    public static BookService getInstance() {
        return null ==bookService
                ? bookService = new BookServiceImpl()
                : bookService;
    }
    @Override
    public boolean saveBook(BookDto bookDto){
         session= PropertiesConfig.getInstance().getSession();
          Transaction transaction=session.beginTransaction();
        try{
            bookRepository.setSession(session);
            boolean isSaved= bookRepository.save(bookDto.toEntity());
            transaction.commit();
            return isSaved;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }
}
