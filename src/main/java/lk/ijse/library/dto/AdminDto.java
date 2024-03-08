package lk.ijse.library.dto;

import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.MobileNo;
import lk.ijse.library.embedded.Name;
import lk.ijse.library.entity.Admin;

import java.io.Serializable;

public class AdminDto implements Serializable {
    private String Id;
    private Name Name;
    private String Email;
    private MobileNo MobileNo;
    private Address address;

    public AdminDto() {
    }

    public AdminDto(String id, lk.ijse.library.embedded.Name name, String email, lk.ijse.library.embedded.MobileNo mobileNo, Address address) {
        Id = id;
        Name = name;
        Email = email;
        MobileNo = mobileNo;
        this.address = address;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "AdminDto{" +
                "Id='" + Id + '\'' +
                ", Name=" + Name +
                ", Email='" + Email + '\'' +
                ", MobileNo=" + MobileNo +
                ", address=" + address +
                '}';
    }
    public Admin toEntity() {
        Admin adminDto = new Admin();
        adminDto.setAddress(this.address);
        adminDto.setId(this.Id);
        adminDto.setEmail(this.Email);
        adminDto.setName(this.Name);
        adminDto.setMobileNo(this.MobileNo);
        return adminDto;
    }
}
