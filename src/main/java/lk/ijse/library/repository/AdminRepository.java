package lk.ijse.library.repository;

import lk.ijse.library.entity.Admin;

public interface AdminRepository extends CRUDRepository<Admin>{
    boolean checkUserNameAndPassword(String userName,String password);
    Admin getAdminId(String userName);
}
