package io.github.zhuyajie666.bookmanagesystem.service;

import io.github.zhuyajie666.bookmanagesystem.dto.BookQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.Book;
import io.github.zhuyajie666.bookmanagesystem.vo.BookVo;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import io.github.zhuyajie666.bookmanagesystem.vo.UserVo;

import java.util.List;

public interface BookService {

    void add(Book book);

    void update(Book book);

    void delete(Integer id);

    PageResult<BookVo> query(BookQueryDto bookQueryDto);

    int countByCategoryId(Integer categoryId);

    BookVo getById(Integer bookId);

    boolean subtractInventory(Integer bookId, int num);

    Book getByIsbn(String isbn);

    void addInventory(Integer bookId, List<String> isbnList);

    boolean isBorrowed(String isbn);

    boolean borrow(String isbn);

    boolean returnBack(String isbn);
}
