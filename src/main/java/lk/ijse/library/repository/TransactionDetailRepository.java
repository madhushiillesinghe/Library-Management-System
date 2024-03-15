package lk.ijse.library.repository;

import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Transaction;
import lk.ijse.library.entity.TransactionDetail;
import org.hibernate.Session;

import java.util.List;

public interface TransactionDetailRepository  extends CRUDRepository<TransactionDetail>{

     List<Integer> getAllBorrowBookIds(int id) ;
     List<Integer> getAllBookId(int id) ;


    }
