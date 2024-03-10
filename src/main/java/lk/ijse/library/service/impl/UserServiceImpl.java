package lk.ijse.library.service.impl;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.UserDto;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Users;
import lk.ijse.library.repository.AdminRepository;
import lk.ijse.library.repository.UserRepository;
import lk.ijse.library.repository.impl.AdminRepositoryImpl;
import lk.ijse.library.repository.impl.UserRepositoryImpl;
import lk.ijse.library.service.AdminService;
import lk.ijse.library.service.UserService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean updateUser(UserDto userDto) {
        session= PropertiesConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try{
            userRepository.setSession(session);
            boolean isUpdate= userRepository.update(userDto.toEntity());
            transaction.commit();
            return isUpdate;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean deleteUser(UserDto userDto) {
        session= PropertiesConfig.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        try {
            userRepository.setSession(session);
            Users users=new Users(userDto.getId(),userDto.getName(),userDto.getEmail(),userDto.getMobileNo(),userDto.getAddress(),userDto.getUserName(),userDto.getPassword());
            boolean isDelete= userRepository.delete(users);
            transaction.commit();
            return  isDelete;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public List<UserDto> getAllUserId() {
        List<Users> userIds = new ArrayList<>();
        List<UserDto> userIdsDto=new ArrayList<>();
        session = PropertiesConfig.getInstance().getSession();
        try {
            userRepository.setSession(session);
            userIds=userRepository.getAllUser();
            for(Users user:userIds){
                userIdsDto.add(new UserDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getMobileNo(),
                        user.getAddress(),
                        user.getUserName(),
                        user.getPassword()
                ) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userIdsDto;
    }

    @Override
    public List<Integer> getAllUserName() {
        session = PropertiesConfig.getInstance().getSession();
        List<Integer> userIds=new ArrayList<>();

        try {
            userRepository.setSession(session);
            userIds=userRepository.getAllUserIds();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return userIds;    }

    @Override
    public UserDto getData(int id) {
        session = PropertiesConfig.getInstance().getSession();

        try{
            userRepository.setSession(session);
            Users user = userRepository.getId(id);
            UserDto userDto=new UserDto(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getMobileNo(),
                    user.getAddress(),
                    user.getUserName(),
                    user.getPassword()
            );
            return userDto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public UserDto getDtodata(int id) {
        session = PropertiesConfig.getInstance().getSession();

        try{
            userRepository.setSession(session);
            Users user = userRepository.getId(id);
            UserDto userDto=new UserDto(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getMobileNo(),
                    user.getAddress(),
                    user.getUserName(),
                    user.getPassword()
            );
            return userDto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
}
