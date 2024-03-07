package lk.ijse.library.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
private String Id;
private String Name;
private String Email;
private int MobileNo;
}
