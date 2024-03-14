package lk.ijse.library.repository;

import lk.ijse.library.entity.Transaction;

import java.util.List;

public interface TransactionRepository extends CRUDRepository<Transaction> {
    List<Transaction> getAllTransactionId();
     List<Transaction> getSomeTransactionId(int id);

    }
