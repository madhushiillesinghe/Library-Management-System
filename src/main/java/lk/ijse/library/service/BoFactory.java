package lk.ijse.library.service;

import lk.ijse.library.repository.SuperRepository;
import lk.ijse.library.service.impl.*;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){
    }
    public static BoFactory getBoFactory(){
        return (boFactory==null)?boFactory=new BoFactory():boFactory;
    }
    public enum BOType{
        ADMIN,USERS,BOOK,BRANCH,TRANSACTION
    }
    public  SuperService getBo(BOType boType){
        switch (boType){
            case ADMIN:return new AdminServiceImpl();
            case USERS:return new UserServiceImpl();
            case TRANSACTION:return new TransactionServiceImpl();
            case BRANCH:return new BranchServiceImpl();
            case BOOK:return new BookServiceImpl();
            default: return null;
        }

    }
}
