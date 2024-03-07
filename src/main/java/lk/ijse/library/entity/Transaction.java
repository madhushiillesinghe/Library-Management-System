package lk.ijse.library.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "transaction_id")
    private String id;
    @Column(name = "transaction_type")
    private String type;
    @Column(name = "borrow_date")
    private Date borrowDate;
    @Column(name = "return_date")
    private Date returnDate;
}
