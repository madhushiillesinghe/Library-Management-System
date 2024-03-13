package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.TransactionDetailDto;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.TransactionDetail;
import lk.ijse.library.repository.BookRepository;
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
        bookRepository = BookRepositoryImpl.getInstance();
        transactionRepository= TransactionRepositoryImpl.getInstance();
        transactionDetailRepository= TransactionDetailRepositoryImpl.getInstance();

    }
    public static TransactionService getInstance() {
        return null ==transactionService
                ? transactionService = (TransactionService) BoFactory.getBoFactory().getBo(BoFactory.BOType.TRANSACTION)
                : transactionService;
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
    public boolean saveUserBookBorrow(TransactionDto transactionDto, List<String>bookList, TransactionDetailDto transactionDetailDto) {
        boolean result=false;
        session=PropertiesConfig.getInstance().getSession();
        Transaction borrowtransaction =session.beginTransaction();

        try{
            transactionRepository.setSession(session);
            lk.ijse.library.entity.Transaction transactionEntity=new lk.ijse.library.entity.Transaction();
            transactionEntity.setUsers(transactionDto.getUsers().toEntity());
            transactionEntity.setReturnDate(transactionDto.getReturnDate());
            transactionEntity.setStatus(transactionDto.getStatus());
            transactionEntity.setId(transactionDto.getId());
            transactionEntity.setBorrowDate(transactionDto.getBorrowDate());

            boolean isSavedTransaction=transactionRepository.save(transactionEntity);

            if(isSavedTransaction){

                bookRepository.setSession(session);
                boolean isBookUpdated=bookRepository.UpdateTransactionBook(bookList);
                if(isBookUpdated){
                    transactionDetailRepository.setSession(session);
                    TransactionDetail transactionDetail=new TransactionDetail();

                    transactionDetail.setTransaction(new lk.ijse.library.entity.Transaction(transactionDto.getId()
                    ,transactionDto.getStatus()
                    ,transactionDto.getBorrowDate()
                    ,transactionDto.getReturnDate()
                    ,transactionDto.toEntity().getUsers()));

                    Book book=bookRepository.getName(bookList.get(0));
                    transactionDetail.setBook(book);

                boolean isTransactionDetailSaved=transactionDetailRepository.saveTransactinDetail(transactionDetail);
                if(isTransactionDetailSaved){
                borrowtransaction.commit();
                result=true;
                }
                }
            }
        }catch (Exception e){
        e.printStackTrace();
        borrowtransaction.rollback();
        result=false;
        }finally {
            session.close();
        }
        return result;
        }
}
