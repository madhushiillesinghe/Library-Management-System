package lk.ijse.library.entity;

import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "book_branch")
public class Branches {
    @Id
    @Column(name = "branch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "branch_location")
    private String location;
    @Column(name = "branch_head_name")
    private String head_Name;
    @Column(name = "book_total")
    private int bookTotal;
    @ManyToOne
    @JoinColumn(name ="admin_Id" )
    private Admin admin;

}
