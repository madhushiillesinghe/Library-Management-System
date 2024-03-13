package lk.ijse.library.repository;

import lk.ijse.library.entity.Book;

import java.util.List;

public interface BookRepository extends CRUDRepository<Book>{
     List<Book> getAllBookId();
     List<Integer> getAllBookIds();
     List<String> getAllBookName();
     boolean updateBorrowBook(Book entity,List<String>bookName);
     boolean UpdateTransactionBook(List<String>bookName);

}
