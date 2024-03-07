package lk.ijse.library.entity;

import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.Name;

import javax.persistence.*;

@Entity
@Table(name = "book_branch")
public class Branches {
    @Id
    @Column(name = "brach_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    @Column(name = "branch_location")
    private Address location;
    @Column(name = "branch_head_name")
    private Name head_Name;
    @Column(name = "book_total")
    private int bookTotal;
    @ManyToOne
    private Admin admin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public Name getHead_Name() {
        return head_Name;
    }

    public void setHead_Name(Name head_Name) {
        this.head_Name = head_Name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


    public int getBookTotal() {
        return bookTotal;
    }

    public void setBookTotal(int bookTotal) {
        this.bookTotal = bookTotal;
    }

    @Override
    public String toString() {
        return "Branches{" +
                "id='" + id + '\'' +
                ", location=" + location +
                ", head_Name=" + head_Name +
                ", bookTotal=" + bookTotal +
                '}';
    }
}
