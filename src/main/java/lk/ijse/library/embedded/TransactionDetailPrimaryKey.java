package lk.ijse.library.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TransactionDetailPrimaryKey implements Serializable {
    @Column(name = "transaction_id")
    private int transactionId;
    @Column(name = "book_Id")
    private int bookId;

    public TransactionDetailPrimaryKey(int transactionId, int bookId) {
        this.transactionId = transactionId;
        this.bookId = bookId;
    }

    public TransactionDetailPrimaryKey() {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "TransactionDetailPrimaryKey{" +
                "transactionId=" + transactionId +
                ", bookId=" + bookId +
                '}';
    }
}
