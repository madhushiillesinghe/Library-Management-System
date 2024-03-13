package lk.ijse.library.entity;

import lk.ijse.library.embedded.TransactionDetailPrimaryKey;

import javax.persistence.*;

@Entity
@Table(name = "transaction_detail")
public class TransactionDetail {

    @ManyToOne
    @JoinColumn(name = "transaction_id",referencedColumnName = "transaction_id",
            insertable = false,
            updatable = false
    )
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "book_id",
            insertable = false,
            updatable = false
    )
    private Book book;

    public TransactionDetailPrimaryKey getTransactionDetailPrimaryKey() {
        return transactionDetailPrimaryKey;
    }

    public void setTransactionDetailPrimaryKey(TransactionDetailPrimaryKey transactionDetailPrimaryKey) {
        this.transactionDetailPrimaryKey = transactionDetailPrimaryKey;
    }

    @EmbeddedId
    private TransactionDetailPrimaryKey transactionDetailPrimaryKey;

    public TransactionDetail() {
    }

    public TransactionDetail(Transaction transaction, Book book) {
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
        return "TransactionDetail{" +
                "transaction=" + transaction +
                ", book=" + book +
                '}';
    }
}
