package lk.ijse.library.service;

import lk.ijse.library.dto.BookDto;

import java.util.List;

public interface TransactionService {
    BookDto getDtodata(int id);
    List<String> getAllBookTitle();
     BookDto getData(String id);
}
