package lk.ijse.library.service;

import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.dto.UserDto;

public interface UserService {
    boolean saveUser(UserDto userDto);
}
