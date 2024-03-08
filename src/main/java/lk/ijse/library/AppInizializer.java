package lk.ijse.library;

import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.MobileNo;
import lk.ijse.library.embedded.Name;
import lk.ijse.library.entity.Admin;
import lk.ijse.library.service.AdminService;
import lk.ijse.library.service.impl.AdminServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class AppInizializer {
    public static void main(String[] args) {
        AdminService adminService=new AdminServiceImpl();
        adminService.saveAdmin(setData());

    }

    private static AdminDto setData() {
        Admin admin=new Admin();
        admin.setMobileNo(setMobileNo().get(0));
        admin.setMobileNo(setMobileNo().get(1));
        admin.setAddress(setAddress());
        admin.setName(setName());
        admin.setId(1);
        admin.setEmail("madhushiillesinghe225@gmail.com");
        AdminDto adminDto=new AdminDto(admin.getId(),admin.getName(),admin.getEmail(),admin.getMobileNo(),admin.getAddress());
        return adminDto;
    }

    private static List<MobileNo> setMobileNo() {
        List<MobileNo> mobileNoList=new ArrayList<>();
        MobileNo mobileNo=new MobileNo();
        mobileNo.setMobileNo("0776210846");
        mobileNo.setType("Mobile");
        mobileNoList.add(mobileNo);

        MobileNo  mobileNo1=new MobileNo();
        mobileNo1.setMobileNo("0913915090");
        mobileNo1.setType("Home");
        mobileNoList.add(mobileNo1);
        return  mobileNoList;
    }

    private static Address setAddress() {
        Address address=new Address();
        address.setCity("Galle");
        address.setStreet("Mahamodar");
        return address;
    }

    private static Name setName() {
        Name name=new Name();
        name.setFirstName("kamal");
        name.setLastName("Gmage");
        return name;
    }
}
