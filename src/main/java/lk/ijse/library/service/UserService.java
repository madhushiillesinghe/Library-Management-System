package lk.ijse.library.service;

import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.UserDto;

import java.util.List;

public interface UserService {
    boolean saveUser(UserDto userDto);
    boolean updateUser(UserDto userDto);
    boolean deleteUser(UserDto userDto);
    List<UserDto> getAllUserId();
    List<Integer> getAllUserName();
    UserDto getData(int name);
    UserDto getDtodata(int id);
}
