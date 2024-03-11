package lk.ijse.library.repository;

import lk.ijse.library.entity.Admin;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Users;

import java.util.List;

public interface UserRepository extends CRUDRepository<Users> {
    List<Users> getAllUser();
    List<Integer> getAllUserIds();
    boolean checkUserNameAndPassword(String userName,String password);
    Users getUserId(String userName);
}
