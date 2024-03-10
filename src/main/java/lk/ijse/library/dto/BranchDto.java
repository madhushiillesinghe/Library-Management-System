package lk.ijse.library.dto;

import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.Name;
import lk.ijse.library.entity.Admin;
import lk.ijse.library.entity.Branches;

public class BranchDto {
    private String id;
    private Address location;
    private Name head_Name;
    private int bookTotal;

    public BranchDto(String id, Address location, Name head_Name, int bookTotal, Admin admin) {
        this.id = id;
        this.location = location;
        this.head_Name = head_Name;
        this.bookTotal = bookTotal;
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    private Admin admin;

    public BranchDto() {
    }



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

    public int getBookTotal() {
        return bookTotal;
    }

    public void setBookTotal(int bookTotal) {
        this.bookTotal = bookTotal;
    }

    @Override
    public String toString() {
        return "BranchDto{" +
                "id='" + id + '\'' +
                ", location=" + location +
                ", head_Name=" + head_Name +
                ", bookTotal=" + bookTotal +
                '}';
    }
    public Branches toEntity(){
        Branches branchDto=new Branches();
        branchDto.setId(this.id);
        branchDto.setLocation(this.location);
        branchDto.setBookTotal(this.bookTotal);
        branchDto.setHead_Name(this.head_Name);
        branchDto.setAdmin(this.admin);
        return branchDto;
    }
}
