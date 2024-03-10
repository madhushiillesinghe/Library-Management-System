package lk.ijse.library.repository.impl;

import lk.ijse.library.entity.Admin;
import lk.ijse.library.entity.Users;
import lk.ijse.library.repository.AdminRepository;
import org.hibernate.Session;

public class AdminRepositoryImpl implements AdminRepository {
    private Session session;
    private static AdminRepositoryImpl adminRepositoryimpl;
    public AdminRepositoryImpl(){

    }
    public static AdminRepositoryImpl getInstance(){
        return null==adminRepositoryimpl
                ?adminRepositoryimpl=new AdminRepositoryImpl()
                :adminRepositoryimpl;
    }
    @Override
    public boolean save(Admin entity) {
        try{
            session.save(entity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }


    @Override
    public boolean update(Admin entity) {
        try{
            session.update(entity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Admin get(String id) {
        try{
            Admin admin=session.get(Admin.class,id);
            return admin;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public boolean delete(Admin entity) {
        try{
            session.delete(entity);
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
