package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.UserDto;
import lk.ijse.library.repository.AdminRepository;
import lk.ijse.library.repository.UserRepository;
import lk.ijse.library.repository.impl.AdminRepositoryImpl;
import lk.ijse.library.repository.impl.UserRepositoryImpl;
import lk.ijse.library.service.AdminService;
import lk.ijse.library.service.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        session= PropertiesConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try{
            userRepository.setSession(session);
            boolean isSaved= userRepository.save(userDto.toEntity());
            transaction.commit();
            return isSaved;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }
}
