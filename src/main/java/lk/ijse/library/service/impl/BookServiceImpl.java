package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.entity.Book;
import lk.ijse.library.repository.BookRepository;
import lk.ijse.library.repository.impl.BookRepositoryImpl;
import lk.ijse.library.service.BookService;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public boolean deleteBook(BookDto bookDto) {
        session= PropertiesConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            bookRepository.setSession(session);
            Book book=new Book(bookDto.getId(),bookDto.getTitle(),bookDto.getGenre(),bookDto.getAuthor(),bookDto.getCount(),bookDto.getAdmin());
            boolean isDelete= bookRepository.delete(book);
            transaction.commit();
            return  isDelete;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public  List<BookDto> getAllBookId() {
        List<Book> bookIds = new ArrayList<>();
        List<BookDto> bookIdsDto=new ArrayList<>();
         session = PropertiesConfig.getInstance().getSession();
        try {
            bookRepository.setSession(session);
            bookIds=bookRepository.getAllBookId();
            for(Book book:bookIds){
                bookIdsDto.add(new BookDto(book.getId(),book.getTitle(),book.getGenre(),book.getAuthor(),book.getCount(),book.getAdmin()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bookIdsDto;
    }

    @Override
    public List<Integer> getAllBookName() {
        session = PropertiesConfig.getInstance().getSession();
        List<Integer> bookIds=new ArrayList<>();

        try {
            bookRepository.setSession(session);
            bookIds=bookRepository.getAllBookIds();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return bookIds;
    }


    @Override
    public  BookDto getData(int id) {
     session = PropertiesConfig.getInstance().getSession();

     try{
         bookRepository.setSession(session);
         Book  book = bookRepository.getId(id);
         BookDto bookDto=new BookDto(book.getId(),book.getTitle(),book.getGenre(),book.getAuthor(),book.getCount(),book.getAdmin());
         return bookDto;
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
            bookRepository.setSession(session);
            Book  book = bookRepository.getId(id);
            BookDto bookDto=new BookDto(book.getId(),book.getTitle(),book.getGenre(),book.getAuthor(),book.getCount(),book.getAdmin());
            return bookDto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }    }
}
