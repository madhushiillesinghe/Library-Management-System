package lk.ijse.library.service;

import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.entity.Admin;

public interface AdminService extends SuperService{
    boolean saveAdmin(AdminDto adminDto);
    boolean checkUserNameAndPassword(String userName,String password);
    AdminDto getAdminId(String userName);

}
