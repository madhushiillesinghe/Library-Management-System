package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.entity.Admin;
import lk.ijse.library.entity.Book;
import lk.ijse.library.repository.BookRepository;
import lk.ijse.library.repository.impl.BookRepositoryImpl;
import lk.ijse.library.service.BookService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean updateBook(BookDto bookDto) {
        session= PropertiesConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try{
            bookRepository.setSession(session);
            boolean isUpdate= bookRepository.update(bookDto.toEntity());
            transaction.commit();
            return isUpdate;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public  List<Book> getAllBookId() {
        List<Book> bookIds = new ArrayList<>();
        Session session = PropertiesConfig.getInstance().getSession();
        try {
            Query<Book> query = session.createQuery("SELECT i FROM  lk.ijse.library.entity.Book i", Book.class);
           bookIds = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bookIds;
    }

    @Override
    public  Book getData(int id) {
        session = PropertiesConfig.getInstance().getSession();
        try{
            Book  book = session.get(Book.class, id);
            return book;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public BookDto getDtodata(int id) {
        session = PropertiesConfig.getInstance().getSession();
        try{
            Book  book = session.get(Book.class, id);
            BookDto bookDto=new BookDto(book.getId(),book.getTitle(),book.getGenre(),book.getAuthor(),book.getCount());
            return bookDto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }    }
}
