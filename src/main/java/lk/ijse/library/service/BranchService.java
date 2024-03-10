package lk.ijse.library.service;

import lk.ijse.library.dto.BookDto;
import lk.ijse.library.dto.BranchDto;

import java.util.List;

public interface BranchService {
    boolean saveBranch(BranchDto branchDto);
    boolean updateBranch(BranchDto branchDto);
    boolean deleteBranch(BranchDto branchDto);
    List<BranchDto> getAllBranchId();
    List<Integer> getAllBranchIds();
    BranchDto getData(int id);
    BranchDto getDtodata(int id);
}
