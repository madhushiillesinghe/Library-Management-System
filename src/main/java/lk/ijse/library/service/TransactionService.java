package lk.ijse.library.service;

import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.TransactionDetailDto;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.entity.TransactionDetail;

import java.util.List;

public interface TransactionService extends SuperService{
    BookDto getDtodata(int id);
    List<String> getAllBookTitle();
     BookDto getData(String id);
     boolean saveTransaction(TransactionDto transactionDto);
    boolean saveUserBookBorrow(TransactionDto transactionDto, List<BookDto> bookList);

}
