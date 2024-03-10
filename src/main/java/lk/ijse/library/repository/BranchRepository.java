package lk.ijse.library.repository;

import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Branches;

import java.util.List;

public interface BranchRepository extends CRUDRepository<Branches> {
    List<Branches> getAllBranch();
    List<Integer> getAllBranchIds();
}
