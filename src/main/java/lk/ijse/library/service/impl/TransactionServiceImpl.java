package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.entity.Book;
import lk.ijse.library.repository.BookRepository;
import lk.ijse.library.repository.impl.BookRepositoryImpl;
import lk.ijse.library.service.TransactionService;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private Session session;
    private final BookRepository bookRepository;
    private static TransactionService transactionService;

    public TransactionServiceImpl() {
        bookRepository = BookRepositoryImpl.getInstance();
    }
    public static TransactionService getInstance() {
        return null ==transactionService
                ? transactionService = new TransactionServiceImpl()
                : transactionService;
    }
    @Override
    public BookDto getDtodata(int id) {
        session = PropertiesConfig.getInstance().getSession();

        try{
            bookRepository.setSession(session);
            Book book = bookRepository.getId(id);
            BookDto bookDto=new BookDto(book.getId(),book.getTitle(),book.getGenre(),book.getAuthor(),book.getStatus(),book.getAdmin());
            return bookDto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }    }

    @Override
    public List<String> getAllBookTitle() {
        session = PropertiesConfig.getInstance().getSession();
        List<String> bookName=new ArrayList<>();
        try {
            bookRepository.setSession(session);
            bookName=bookRepository.getAllBookName();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return bookName;
    }
    @Override
    public  BookDto getData(String id) {
        session = PropertiesConfig.getInstance().getSession();

        try{
            bookRepository.setSession(session);
            Book  book = bookRepository.getName(id);
            BookDto bookDto=new BookDto(book.getId(),book.getTitle(),book.getGenre(),book.getAuthor(),book.getStatus(),book.getAdmin());
            return bookDto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
}
