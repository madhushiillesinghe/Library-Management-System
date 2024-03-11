package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.entity.Book;
import lk.ijse.library.repository.BookRepository;
import lk.ijse.library.repository.impl.BookRepositoryImpl;
import lk.ijse.library.service.TransactionService;
import org.hibernate.Session;

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
            BookDto bookDto=new BookDto(book.getId(),book.getTitle(),book.getGenre(),book.getAuthor(),book.getCount(),book.getAdmin());
            return bookDto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }    }
}
