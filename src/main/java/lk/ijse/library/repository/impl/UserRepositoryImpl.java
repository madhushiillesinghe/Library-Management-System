package lk.ijse.library.repository.impl;

import lk.ijse.library.entity.Admin;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Users;
import lk.ijse.library.repository.DAOFactory;
import lk.ijse.library.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private Session session;
    private static UserRepositoryImpl userRepositoryImpl;
    public UserRepositoryImpl(){

    }
    public static UserRepositoryImpl getInstance() {
        return null == userRepositoryImpl
                ? userRepositoryImpl = (UserRepositoryImpl) DAOFactory.getDADFactory().getDao(DAOFactory.DAOType.USERS)
                : userRepositoryImpl;
    }
    @Override
    public boolean save(Users entity) {
            session.save(entity);
            return true;
    }

    @Override
    public boolean update(Users entity) {
            session.update(entity);
            return true;
    }

    @Override
    public Users getId(int id) {
            Users users=session.get(Users.class,id);
            return users;
    }

    @Override
    public Users getName(String name) {
            Users users=session.get(Users.class,name);
            return users;

    }


    @Override
    public boolean delete(Users entity) {
            session.delete(entity);
            return true;

    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public List<Users> getAllUser() {
        List<Users> userIds = new ArrayList<>();

        Query<Users> query = session.createQuery("SELECT i FROM  lk.ijse.library.entity.Users i", Users.class);
        userIds = query.getResultList();
        return userIds;

    }


    @Override
    public List<Integer> getAllUserIds() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> criteriaQuery=builder.createQuery(Users.class);
        Root<Users> root=criteriaQuery.from(Users.class);
        criteriaQuery.select(root);

        List<Users> entities=session.createQuery(criteriaQuery).getResultList();
        List<Integer> userIds=new ArrayList<>();
        List<Users>userList=new ArrayList<>();
        for(int i=0;i<entities.size();i++){
            userList.add(entities.get(i));
        }
        for(int i=0;i<userList.size();i++){
            userIds.add(userList.get(i).getId());
        }
        return userIds;
    }

    @Override
    public boolean checkUserNameAndPassword(String userName, String password) {
        String JPQLQuery ="SELECT count(A)" +
                "FROM Users A " +
                "WHERE A.userName=:userName " +
                "AND A.password=:password";

        Query query = session.createQuery(JPQLQuery)
                .setParameter("userName", userName)
                .setParameter("password", password);

        Long count = (Long) query.uniqueResult();
        return count>0 ;
    }

    @Override
    public Users getUserId(String userName) {
        String JPQLQuery="SELECT A FROM Users A " +
                "WHERE A.userName=:username";

        Query query = session.createQuery(JPQLQuery)
                .setParameter("username",userName);
        return (Users) query.uniqueResult();
    }

}
