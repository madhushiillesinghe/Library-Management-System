package lk.ijse.library.dto;

import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.MobileNo;
import lk.ijse.library.embedded.Name;
import lk.ijse.library.entity.Users;

public class UserDto {
    private int Id;
    private  Name Name;
    private String Email;
    private MobileNo MobileNo;
    private Address address;
    private String userName;
    private String password;

    public UserDto() {
    }

    public UserDto(int id, Name name, String email, MobileNo mobileNo, Address address, String userName, String password) {
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
        return "UserDto{" +
                "Id='" + Id + '\'' +
                ", Name=" + Name +
                ", Email='" + Email + '\'' +
                ", MobileNo=" + MobileNo +
                ", address=" + address +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public Users toEntity(){
        Users userDto=new Users();
        userDto.setId(this.Id);
        userDto.setUserName(this.userName);
        userDto.setPassword(this.password);
        userDto.setEmail(this.Email);
        userDto.setAddress(this.address);
        userDto.setName(this.Name);
        userDto.setMobileNo(this.MobileNo);
        return userDto;
    }
}
