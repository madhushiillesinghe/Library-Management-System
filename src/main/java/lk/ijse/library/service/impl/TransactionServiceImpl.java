package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.controller.AddTransactionFormController;
import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.TransactionDetailDto;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.embedded.TransactionDetailPrimaryKey;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.TransactionDetail;
import lk.ijse.library.repository.BookRepository;
import lk.ijse.library.repository.DAOFactory;
import lk.ijse.library.repository.TransactionDetailRepository;
import lk.ijse.library.repository.TransactionRepository;
import lk.ijse.library.repository.impl.BookRepositoryImpl;
import lk.ijse.library.repository.impl.TransactionDetailRepositoryImpl;
import lk.ijse.library.repository.impl.TransactionRepositoryImpl;
import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private Session session;
    private final BookRepository bookRepository;
    private  final TransactionRepository transactionRepository;
    private final TransactionDetailRepository transactionDetailRepository;
    private static TransactionService transactionService;

    public TransactionServiceImpl() {
        bookRepository = (BookRepository) DAOFactory.getDADFactory().getDao(DAOFactory.DAOType.BOOK);
        transactionRepository= (TransactionRepository) DAOFactory.getDADFactory().getDao(DAOFactory.DAOType.TRANSACTION);
        transactionDetailRepository= (TransactionDetailRepository) DAOFactory.getDADFactory().getDao(DAOFactory.DAOType.TRANSACTIONDETAIL);

    }

    @Override
    public BookDto getDtodata(int id) {
        session = PropertiesConfig.getInstance().getSession();

        try{
            bookRepository.setSession(session);
            Book book = bookRepository.getId(id);
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

            AdminDto adminDto=new AdminDto(book.getAdmin().getId()
                    ,book.getAdmin().getName()
                    ,book.getAdmin().getEmail()
                    ,book.getAdmin().getMobileNo()
                    ,book.getAdmin().getAddress()
                    ,book.getAdmin().getUserName()
                    ,book.getAdmin().getPassword());
            BookDto bookDto=new BookDto(book.getId()
                    ,book.getTitle()
                    ,book.getGenre()
                    ,book.getAuthor()
                    ,book.getStatus()
                    ,adminDto);
            return bookDto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean saveTransaction(TransactionDto transactionDto) {
      /*  lk.ijse.library.entity.Transaction transactionEntity=new lk.ijse.library.entity.Transaction();
        transactionEntity.setUsers(transactionDto.getUsers().toEntity());
        transactionEntity.setReturnDate(transactionDto.getReturnDate());
        transactionEntity.setStatus(transactionDto.getStatus());
        transactionEntity.setId(transactionDto.getId());
        transactionEntity.setBorrowDate(transactionDto.getBorrowDate());

        session=PropertiesConfig.getInstance().getSession();
        Transaction borrowtransaction =session.beginTransaction();
        transactionRepository.setSession(session);
        transactionRepository.save(transactionEntity);

        for(BookDto borrowBook: AddTransactionFormController.getInstance().bookBorrow){
            bookRepository.setSession(session);
            bookRepository.update(new Book(borrowBook.getId()
            ,borrowBook.getTitle()
            ,borrowBook.getGenre()
            ,borrowBook.getAuthor()
            ,borrowBook.getStatus()
            ,borrowBook.toEntity().getAdmin()));

            TransactionDetail transactionDetail=new TransactionDetail();
            transactionDetail.setTransaction(transactionEntity);
                    Book book=new Book(borrowBook.getId()
                    ,borrowBook.getTitle()
                    ,borrowBook.getGenre()
                    ,borrowBook.getAuthor()
                    ,borrowBook.getStatus()
                    ,borrowBook.toEntity().getAdmin());
            transactionDetail.setBook(book);

            transactionDetail.setTransactionDetailPrimaryKey(new TransactionDetailPrimaryKey(transactionEntity.getId(),book.getId()));
            transactionDetailRepository.setSession(session);
            transactionDetailRepository.save(transactionDetail);
        }
        try{
            borrowtransaction.commit();
            return true;
        }catch (Exception e){
            borrowtransaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();*/
        return false;

    }

    @Override
    public boolean saveUserBookBorrow(TransactionDto transactionDto, List<BookDto> bookList) {
        lk.ijse.library.entity.Transaction transactionEntity = new lk.ijse.library.entity.Transaction();
        transactionEntity.setUsers(transactionDto.getUsers().toEntity());
        transactionEntity.setReturnDate(transactionDto.getReturnDate());
        transactionEntity.setStatus(transactionDto.getStatus());
        transactionEntity.setId(transactionDto.getId());
        transactionEntity.setBorrowDate(transactionDto.getBorrowDate());

        session = PropertiesConfig.getInstance().getSession();
        Transaction borrowtransaction = session.beginTransaction();

        transactionRepository.setSession(session);
        transactionRepository.save(transactionEntity);

        for (BookDto bookDto : bookList) {

            Book book = new Book();
            book.setStatus(bookDto.getStatus());
            book.setGenre(bookDto.getGenre());
            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setId(bookDto.getId());
            book.setAdmin(bookDto.toEntity().getAdmin());


            bookRepository.setSession(session);
            bookRepository.update(book);


            TransactionDetail transactionDetail = new TransactionDetail();

            transactionDetail.setTransaction(transactionEntity);
            transactionDetail.setBook(book);
            transactionDetail.setTransactionDetailPrimaryKey(new TransactionDetailPrimaryKey(transactionEntity.getId(), book.getId()));

            transactionDetailRepository.setSession(session);
            transactionDetailRepository.save(transactionDetail);
        }
        try {
            borrowtransaction.commit();
            return true;
        } catch (Exception e) {
            borrowtransaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
