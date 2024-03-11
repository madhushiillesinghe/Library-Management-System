package lk.ijse.library.repository;

import java.sql.SQLException;
import java.util.List;

public interface CRUDRepository <T> extends SuperRepository{
    boolean save(final T entity);
    boolean update(T entity);
    T getId( int id);
    T getName( String name);
    boolean delete(T dto);

}
