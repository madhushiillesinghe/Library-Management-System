package lk.ijse.library.dto;

import lk.ijse.library.entity.Transaction;
import lk.ijse.library.entity.Users;

import java.sql.Timestamp;
import java.util.Date;

public class TransactionDto {
    private int id;
    private String status;
    private Timestamp borrowDate;
    private String returnDate;
    private UserDto users;

    public TransactionDto() {
    }

    public TransactionDto(int id, String status, Timestamp borrowDate, String returnDate, UserDto users) {
        this.id = id;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.users = users;
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

    public Timestamp getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Timestamp borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public UserDto getUsers() {
        return users;
    }

    public void setUsers(UserDto users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", users=" + users +
                '}';
    }
    public Transaction toEntity(){
        Transaction transaction=new Transaction();
        transaction.setId(this.id);
        transaction.setBorrowDate(this.borrowDate);
        transaction.setStatus(this.status);
        transaction.setReturnDate(this.returnDate);
        transaction.setUsers(this.users.toEntity());
        return transaction;
    }
}
