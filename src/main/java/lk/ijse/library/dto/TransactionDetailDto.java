package lk.ijse.library.dto;

import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Transaction;
import lk.ijse.library.entity.TransactionDetail;

public class TransactionDetailDto {
    private Transaction transaction;
    private Book book;

    public TransactionDetailDto() {
    }

    public TransactionDetailDto(Transaction transaction, Book book) {
        this.transaction = transaction;
        this.book = book;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "TransactionDetailDto{" +
                "transaction=" + transaction +
                ", book=" + book +
                '}';
    }
    public TransactionDetail toEntity(){
        TransactionDetail transactionDetail=new TransactionDetail();
        transactionDetail.setBook(this.book);
        transactionDetail.setTransaction(this.transaction);
        return transactionDetail;
    }
}
