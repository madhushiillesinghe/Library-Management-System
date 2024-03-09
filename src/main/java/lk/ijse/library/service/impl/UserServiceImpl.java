package lk.ijse.library.service.impl;

import lk.ijse.library.dto.UserDto;
import lk.ijse.library.repository.AdminRepository;
import lk.ijse.library.repository.UserRepository;
import lk.ijse.library.repository.impl.AdminRepositoryImpl;
import lk.ijse.library.repository.impl.UserRepositoryImpl;
import lk.ijse.library.service.AdminService;
import lk.ijse.library.service.UserService;
import org.hibernate.Session;

public class UserServiceImpl implements UserService {
    private Session session;
    private final UserRepository userRepository;
    private static UserService userService;

    public UserServiceImpl(){
        userRepository = UserRepositoryImpl.getInstance();
    }
    public static UserService getInstance() {
        return null ==userService
                ? userService = new UserServiceImpl()
                : userService;
    }
    @Override
    public boolean saveUser(UserDto userDto) {
        return false;
    }
}
