package lk.ijse.library.repository.impl;

import lk.ijse.library.entity.Admin;
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
        session.save(entity);
        return true;
    }

    @Override
    public boolean update(Admin dto) {
        return false;
    }

    @Override
    public Admin get(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public void setSession(Session session) {
    this.session=session;
    }
}
