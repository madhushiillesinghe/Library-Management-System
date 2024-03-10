package lk.ijse.library.repository;

import lk.ijse.library.config.PropertiesConfig;
import lk.ijse.library.entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public interface BookRepository extends CRUDRepository<Book>{
     List<Book> getAllBookId();
}
