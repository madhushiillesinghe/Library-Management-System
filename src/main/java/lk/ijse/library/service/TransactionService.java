package lk.ijse.library.service;

import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.TransactionDetailDto;
import lk.ijse.library.dto.TransactionDto;
import lk.ijse.library.entity.TransactionDetail;

import java.util.List;

public interface TransactionService {
    BookDto getDtodata(int id);
    List<String> getAllBookTitle();
     BookDto getData(String id);
    boolean saveUserBookBorrow(TransactionDto transactionDto, List<String> bookList, TransactionDetailDto transactionDetailDto);

}
