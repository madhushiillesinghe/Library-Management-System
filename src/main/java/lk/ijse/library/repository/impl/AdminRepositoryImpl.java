package lk.ijse.library.repository.impl;

import lk.ijse.library.entity.Admin;
import lk.ijse.library.entity.Users;
import lk.ijse.library.repository.AdminRepository;
import lk.ijse.library.repository.DAOFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class AdminRepositoryImpl implements AdminRepository {
    private Session session;
    private static AdminRepositoryImpl adminRepositoryimpl;
    public AdminRepositoryImpl(){

    }
    public static AdminRepositoryImpl getInstance(){
        return null==adminRepositoryimpl
                ?adminRepositoryimpl= (AdminRepositoryImpl) DAOFactory.getDADFactory().getDao(DAOFactory.DAOType.ADMIN)
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
    public Admin getId(int id) {
        try{
            Admin admin=session.get(Admin.class,id);
            return admin;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Admin getName(String name) {
        try{
            Admin admin=session.get(Admin.class,name);
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

    @Override
    public boolean checkUserNameAndPassword(String userName, String password) {
        String JPQLQuery ="SELECT count(A)" +
                "FROM Admin A " +
                "WHERE A.userName=:userName " +
                "AND A.password=:password";

        Query query = session.createQuery(JPQLQuery)
                .setParameter("userName", userName)
                .setParameter("password", password);

        Long count = (Long) query.uniqueResult();
        return count>0 ;

    }

    @Override
    public Admin getAdminId(String userName) {
        String JPQLQuery="SELECT A FROM Admin A " +
                "WHERE A.userName=:username";

        Query query = session.createQuery(JPQLQuery)
                .setParameter("username",userName);
       return (Admin) query.uniqueResult();
    }
}
