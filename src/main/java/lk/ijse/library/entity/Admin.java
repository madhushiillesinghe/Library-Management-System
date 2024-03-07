package lk.ijse.library.entity;

import javax.persistence.*;

import lk.ijse.library.embedded.Name;
import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.MobileNo;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "admin")
public class Admin {

 @Id
 @Column(name = "admin_Id")
 @GeneratedValue(strategy = GenerationType.SEQUENCE)
private String Id;
 @Column(name = "admin_name")
private Name Name;
 @Column(name = "admin_email")
private String Email;
 @Column(name = "admin_mobileno")
private MobileNo MobileNo;
 @Column(name = "admin_address")
private Address address;
 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "admin")
 private List<Users> usersList=new ArrayList<>();

 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "admin")
 private List<Branches> branchesList=new ArrayList<>();

 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "admin")
 private List<Book> bookList=new ArrayList<>();

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public lk.ijse.library.embedded.Name getName() {
        return Name;
    }

    public void setName(lk.ijse.library.embedded.Name name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public lk.ijse.library.embedded.MobileNo getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(lk.ijse.library.embedded.MobileNo mobileNo) {
        MobileNo = mobileNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "Id='" + Id + '\'' +
                ", Name=" + Name +
                ", Email='" + Email + '\'' +
                ", MobileNo=" + MobileNo +
                ", address=" + address +
                '}';
    }
}
