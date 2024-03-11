package lk.ijse.library.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int id;
    @Column(name = "return_type")
    private String status;
    @CreationTimestamp
    @Column(name = "borrow_date")
    private Date borrowDate;
    @CreationTimestamp
    @Column(name = "return_date")
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name ="user_Id" )
    private Users users;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "transaction")
    private List<TransactionDetail> transactionDetails=new ArrayList<>();

    public Transaction(int id, String status, Date borrowDate, Date returnDate, Users users) {
        this.id = id;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.users = users;
    }

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", users=" + users +
                '}';
    }
}
