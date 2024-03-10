package lk.ijse.library.dto;

import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.MobileNo;
import lk.ijse.library.embedded.Name;
import lk.ijse.library.entity.Admin;

import java.io.Serializable;

public class AdminDto implements Serializable {
    private int Id;
    private Name Name;
    private String Email;
    private MobileNo MobileNo;
    private Address address;
    private String userName;
    private String password;

    public AdminDto(int id, Name name, String email, MobileNo mobileNo, Address address, String userName,String password) {
        Id = id;
        Name = name;
        Email = email;
        MobileNo = mobileNo;
        this.address = address;
        this.userName = userName;
        this.password = password;
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



    public AdminDto() {
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


    public Admin toEntity() {
        Admin adminDto = new Admin();
        adminDto.setAddress(this.address);
        adminDto.setId(this.Id);
        adminDto.setEmail(this.Email);
        adminDto.setName(this.Name);
        adminDto.setMobileNo(this.MobileNo);
        adminDto.setPassword(this.password);
        adminDto.setUserName(this.userName);
        return adminDto;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
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
