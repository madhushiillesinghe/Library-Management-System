package lk.ijse.library.dto;

import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Transaction;
import lk.ijse.library.entity.Users;

import java.util.Date;

public class TransactionDto {
    private int id;
    private String status;
    private Date borrowDate;
    private Date returnDate;
    private Users users;

    public TransactionDto() {
    }

    public TransactionDto(int id, String status, Date borrowDate, Date returnDate, Users users) {
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
        transaction.setUsers(this.users);
        return transaction;
    }
}
