package lk.ijse.library.repository.impl;

import lk.ijse.library.entity.Users;
import lk.ijse.library.repository.UserRepository;
import org.hibernate.Session;

public class UserRepositoryImpl implements UserRepository {
    private Session session;
    private static UserRepositoryImpl userRepositoryImpl;
    public UserRepositoryImpl(){

    }
    public static UserRepositoryImpl getInstance() {
        return null == userRepositoryImpl
                ? userRepositoryImpl = new UserRepositoryImpl()
                : userRepositoryImpl;
    }
    @Override
    public boolean save(Users entity) {
        try{
            session.save(entity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Users entity) {
        try{
            session.update(entity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Users get(String id) {
        try{
            Users users=session.get(Users.class,id);
            return users;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(String id) {
        try{
            Users users=session.get(Users.class,id);
            session.delete(users);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
}
