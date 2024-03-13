package lk.ijse.library.dto;

import lk.ijse.library.embedded.Address;
import lk.ijse.library.embedded.Name;
import lk.ijse.library.entity.Admin;
import lk.ijse.library.entity.Branches;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchDto {
    private int id;
    private String location;
    private String head_Name;
    private int bookTotal;
    private AdminDto admin;

    public Branches toEntity(){
        Branches branchDto=new Branches();
        branchDto.setId(this.id);
        branchDto.setLocation(this.location);
        branchDto.setBookTotal(this.bookTotal);
        branchDto.setHead_Name(this.head_Name);
        branchDto.setAdmin(this.admin.toEntity());
        return branchDto;
    }
}
