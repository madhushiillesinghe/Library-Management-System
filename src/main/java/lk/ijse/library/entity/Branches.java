package lk.ijse.library.entity;

import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.Name;

import javax.persistence.*;

@Entity
@Table(name = "book_branch")
public class Branches {
    @Id
    @Column(name = "branch_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "branch_location")
    private String location;
    @Column(name = "branch_head_name")
    private String head_Name;
    @Column(name = "book_total")
    private int bookTotal;
    @ManyToOne
    @JoinColumn(name ="admin_Id" )
    private Admin admin;

    public Branches(int id, String location, String head_Name, int bookTotal, Admin admin) {
        this.id = id;
        this.location = location;
        this.head_Name = head_Name;
        this.bookTotal = bookTotal;
        this.admin = admin;
    }

    public Branches() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHead_Name() {
        return head_Name;
    }

    public void setHead_Name(String head_Name) {
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
