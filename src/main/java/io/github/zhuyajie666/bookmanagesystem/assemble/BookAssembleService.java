package io.github.zhuyajie666.bookmanagesystem.assemble;

import io.github.zhuyajie666.bookmanagesystem.dto.BookBorrowDto;

public interface BookAssembleService {

    void deleteCategory(Integer categoryId);

    void borrow(BookBorrowDto bookBorrowDto);

    void returnBack(Integer userId, String isbn);
}
