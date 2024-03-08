package lk.ijse.library;

import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.MobileNo;
import lk.ijse.library.embedded.Name;
import lk.ijse.library.entity.Admin;
import lk.ijse.library.service.AdminService;
import lk.ijse.library.service.impl.AdminServiceImpl;

public class AppInizializer {
    public static void main(String[] args) {
        AdminService adminService=new AdminServiceImpl();
        adminService.saveAdmin(setData());

    }

    private static AdminDto setData() {
        Admin admin=new Admin();
        setName();
        setAddress();
        setMobileNo();
        admin.setId(1);
        admin.setEmail("madhushiillesinghe225@gmail.com");
        AdminDto adminDto=new AdminDto(admin.getId(),admin.getName(),admin.getEmail(),admin.getMobileNo(),admin.getAddress());
        return adminDto;
    }

    private static void setMobileNo() {
        MobileNo mobileNo=new MobileNo();
        mobileNo.setMobileNo("0776210846");
        mobileNo.setType("Mobile");

        MobileNo  mobileNo1=new MobileNo();
        mobileNo1.setMobileNo("0913915090");
        mobileNo1.setType("Home");
    }

    private static void setAddress() {
        Address address=new Address();
        address.setCity("Galle");
        address.setStreet("Mahamodar");
    }

    private static void setName() {
        Name name=new Name();
        name.setFirstName("kamal");
        name.setLastName("Gmage");
    }
}
