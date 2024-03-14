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
 @GeneratedValue(strategy =GenerationType.IDENTITY)
 @Column(name = "admin_Id")
private int Id;
 @Column(name = "admin_name",nullable = false)
private Name Name;
 @Column(name = "admin_email",nullable = false)
private String Email;
 @Column(name = "admin_mobileno",nullable = false)
private MobileNo MobileNo;
 @Column(name = "admin_address",nullable = false)
private Address address;
    @Column(name = "user_name",nullable = false)
    private String userName;
    @Column(name = "password",nullable = false,unique = true)
    private String password;

    public Admin(int id,Name name, String email, MobileNo mobileNo, Address address, String userName, String password) {
        Id = id;
        Name = name;
        Email = email;
        MobileNo = mobileNo;
        this.address = address;
        this.userName = userName;
        this.password = password;
    }



/* @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "admin")
 private List<Users> usersList=new ArrayList<>();*/

 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "admin")
 private List<Branches> branchesList=new ArrayList<>();

 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "admin")
 private List<Book> bookList=new ArrayList<>();

    public Admin() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Name getName() {
        return Name;
    }

    public void setName(Name name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public MobileNo getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(MobileNo mobileNo) {
        MobileNo = mobileNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "Id=" + Id +
                ", Name=" + Name +
                ", Email='" + Email + '\'' +
                ", MobileNo=" + MobileNo +
                ", address=" + address +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
