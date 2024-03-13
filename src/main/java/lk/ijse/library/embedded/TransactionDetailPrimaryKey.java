package lk.ijse.library.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class TransactionDetailPrimaryKey implements Serializable {
    @Column(name = "transaction_id")
    private int transactionId;
    @Column(name = "book_Id")
    private int bookId;

}
