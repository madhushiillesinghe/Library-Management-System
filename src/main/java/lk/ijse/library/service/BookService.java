package lk.ijse.library.service;

import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.entity.Admin;
import lk.ijse.library.entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public interface BookService {
    boolean saveBook(BookDto bookDto);
    boolean updateBook(BookDto bookDto);
    boolean deleteBook(BookDto bookDto);
     List<BookDto> getAllBookId();
     List<Integer> getAllBookName();
    BookDto getData(String name);
    BookDto getDtodata(int id);
    boolean updateBorrowBook(BookDto bookDto);



}
