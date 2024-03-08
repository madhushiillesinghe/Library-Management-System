package lk.ijse.library.repository;

import org.hibernate.Session;

public interface SuperRepository {
    void setSession(Session session);
}
