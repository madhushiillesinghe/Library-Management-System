package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.entity.Book;
import lk.ijse.library.repository.BookRepository;
import lk.ijse.library.repository.DAOFactory;
import lk.ijse.library.repository.impl.BookRepositoryImpl;
import lk.ijse.library.service.BoFactory;
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
        bookRepository = (BookRepository) DAOFactory.getDADFactory().getDao(DAOFactory.DAOType.BOOK);
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

            Book book=new Book(bookDto.getId(),bookDto.getTitle(),bookDto.getGenre(),bookDto.getAuthor(),bookDto.getStatus(),bookDto.getAdmin().toEntity());
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
                AdminDto adminDto=new AdminDto(book.getAdmin().getId()
                        ,book.getAdmin().getName()
                        ,book.getAdmin().getEmail()
                        ,book.getAdmin().getMobileNo()
                        ,book.getAdmin().getAddress()
                        ,book.getAdmin().getUserName()
                        ,book.getAdmin().getPassword());
                bookIdsDto.add(new BookDto(book.getId(),book.getTitle(),book.getGenre(),book.getAuthor(),book.getStatus(),adminDto));
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
    public  BookDto getData(String id) {
     session = PropertiesConfig.getInstance().getSession();

     try{
         bookRepository.setSession(session);
         Book  book = bookRepository.getName(id);

         AdminDto adminDto=new AdminDto(book.getAdmin().getId()
                 ,book.getAdmin().getName()
                 ,book.getAdmin().getEmail()
                 ,book.getAdmin().getMobileNo()
                 ,book.getAdmin().getAddress()
                 ,book.getAdmin().getUserName()
                 ,book.getAdmin().getPassword());
         BookDto bookDto=new BookDto(book.getId(),book.getTitle(),book.getGenre(),book.getAuthor(),book.getStatus(),adminDto);
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

            AdminDto adminDto=new AdminDto(book.getAdmin().getId()
                    ,book.getAdmin().getName()
                    ,book.getAdmin().getEmail()
                    ,book.getAdmin().getMobileNo()
                    ,book.getAdmin().getAddress()
                    ,book.getAdmin().getUserName()
                    ,book.getAdmin().getPassword());
            BookDto bookDto=new BookDto(book.getId(),book.getTitle(),book.getGenre(),book.getAuthor(),book.getStatus(),adminDto);
            return bookDto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }    }

    @Override
    public boolean updateBorrowBook(BookDto bookDto) {
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


}
