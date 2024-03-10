package lk.ijse.library.repository;

import java.sql.SQLException;
import java.util.List;

public interface CRUDRepository <T> extends SuperRepository{
    boolean save(final T dto);
    boolean update(T dto);
    T getId( int id);
    T getName( String name);
    boolean delete(T dto);

}
