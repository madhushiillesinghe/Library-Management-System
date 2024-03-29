package lk.ijse.library.entity;

import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.MobileNo;
import lk.ijse.library.embedded.Name;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private int Id;
    @Column(name = "user_name",nullable = false)
    private Name Name;
    @Column(name = "user_email",nullable = false)
    private String Email;
    @Column(name = "user_mobileno",nullable = false)
    private MobileNo MobileNo;
    @Column(name = "user_address",nullable = false)
    private Address address;
    @Column(name = "user_Name",nullable = false)
    private String userName;
    @Column(name = "password",nullable = false,unique = true)
    private String password;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "users")
    private List<Transaction> transactionList=new ArrayList<>();


    public Users() {

    }

    public Users(int id, Name name, String email,MobileNo mobileNo, Address address, String userName, String password) {
        Id = id;
        Name = name;
        Email = email;
        MobileNo = mobileNo;
        this.address = address;
        this.userName = userName;
        this.password = password;
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

    public void setName(lk.ijse.library.embedded.Name name) {
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

    public void setMobileNo(lk.ijse.library.embedded.MobileNo mobileNo) {
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
        return "Users{" +
                "Id='" + Id + '\'' +
                ", Name=" + Name +
                ", Email='" + Email + '\'' +
                ", MobileNo=" + MobileNo +
                ", address=" + address +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
