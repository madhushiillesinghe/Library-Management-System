package lk.ijse.library.repository;

import lk.ijse.library.repository.impl.*;

public class DAOFactory {
    private static DAOFactory daOFactory;
    private DAOFactory(){}
    public static DAOFactory getDADFactory (){
        return (daOFactory==null) ? daOFactory=new DAOFactory():daOFactory;
    }
    public enum DAOType{
        ADMIN,USERS,BOOK,BRANCH,TRANSACTION,TRANSACTIONDETAIL,DASHBOARD
    }
    public SuperRepository getDao(DAOType daoType) {
        switch (daoType) {
            case ADMIN: return new AdminRepositoryImpl();
            case USERS:return new UserRepositoryImpl();
            case BOOK:return new BookRepositoryImpl();
            case BRANCH:return new BranchRepositoryImpl();
            case TRANSACTION:return new TransactionRepositoryImpl();
            case TRANSACTIONDETAIL:return new TransactionDetailRepositoryImpl();
            case DASHBOARD:return new DashboardRepositoryImpl();
            default:return null;
        }
    }
}
