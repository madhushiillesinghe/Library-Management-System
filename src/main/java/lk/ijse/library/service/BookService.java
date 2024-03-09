package lk.ijse.library.service;

import lk.ijse.library.dto.AdminDto;
import lk.ijse.library.dto.BookDto;
import lk.ijse.library.entity.Admin;

import java.util.List;

public interface BookService {
    boolean saveBook(BookDto bookDto);
}
