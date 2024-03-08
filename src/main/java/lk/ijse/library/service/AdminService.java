package lk.ijse.library.service;

import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.dto.BookDto;

public interface AdminService {
    boolean saveAdmin(AdminDto adminDto);
}
