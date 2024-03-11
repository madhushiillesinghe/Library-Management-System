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
    @EmbeddedId
    private TransactionDetailPrimaryKey transactionDetailPrimaryKey;

    public TransactionDetail() {
    }
}
