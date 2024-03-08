package lk.ijse.library.service;

import lk.ijse.library.dto.BookDto;

public interface BookService {
    boolean saveBook(BookDto bookDto);
}
