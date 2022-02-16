package io.github.zhuyajie666.bookmanagesystem.controller;

import io.github.zhuyajie666.bookmanagesystem.assemble.BookAssembleService;
import io.github.zhuyajie666.bookmanagesystem.component.TokenManager;
import io.github.zhuyajie666.bookmanagesystem.dto.BookBorrowDto;
import io.github.zhuyajie666.bookmanagesystem.dto.BookIsbnQueryDto;
import io.github.zhuyajie666.bookmanagesystem.dto.BookQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.Book;
import io.github.zhuyajie666.bookmanagesystem.entity.Manager;
import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.form.*;
import io.github.zhuyajie666.bookmanagesystem.service.BookService;
import io.github.zhuyajie666.bookmanagesystem.utils.MapperUtils;
import io.github.zhuyajie666.bookmanagesystem.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookAssembleService bookAssembleService;

    @Autowired
    private TokenManager tokenManager;

    @RequestMapping("/add")
    public ResponseCode add(@RequestBody BookSaveForm bookSaveForm, HttpServletRequest request) {
        Book book = MapperUtils.map(bookSaveForm, Book.class);
        ManagerVo manager = tokenManager.getByToken(request.getHeader("token"));
        book.setCreateBy(manager.getId());
        book.setUpdateBy(manager.getId());
        bookService.add(book);
        return ResponseCode.SUCCESS;
    }

    @RequestMapping("/update")
    public ResponseCode update(@RequestBody BookSaveForm bookSaveForm, HttpServletRequest request) {
        Book book = MapperUtils.map(bookSaveForm, Book.class);
        ManagerVo manager = tokenManager.getByToken(request.getHeader("token"));
        book.setUpdateBy(manager.getId());
        bookService.update(book);
        return ResponseCode.SUCCESS;
    }

    @RequestMapping("/addInventory")
    public ResponseCode addInventory(@RequestBody BookInventoryAddForm bookInventoryAddForm) {
        bookService.addInventory(bookInventoryAddForm.getBookId(),bookInventoryAddForm.getIsbnList());
        return ResponseCode.SUCCESS;
    }

    @RequestMapping("/getById")
    public ResponseCode getById(@RequestBody IdForm idForm) {
        BookVo book = bookService.getById(idForm.getId());
        return ResponseCode.build(book);
    }

    @RequestMapping("/query")
    public ResponseCode query(@RequestBody BookQueryForm bookQueryForm) {
        BookQueryDto bookQueryDto = MapperUtils.map(bookQueryForm, BookQueryDto.class);
        PageResult<BookVo> pageResult = bookService.query(bookQueryDto);
        return ResponseCode.build(pageResult);
    }

    @RequestMapping("/delete")
    public ResponseCode delete(@RequestBody IdForm idForm) {
        bookService.delete(idForm.getId());
        return ResponseCode.SUCCESS;
    }

    @RequestMapping("/queryBookIsbn")
    public ResponseCode queryBookIsbn(@RequestBody BookIsbnQueryForm bookIsbnQueryForm) {
        BookIsbnQueryDto bookIsbnQueryDto = MapperUtils.map(bookIsbnQueryForm, BookIsbnQueryDto.class);
        PageResult<BookIsbnVo> pageResult = bookService.queryBookIsbn(bookIsbnQueryDto);
        return ResponseCode.build(pageResult);
    }

    @RequestMapping("/borrow")
    public ResponseCode borrow(@RequestBody BookBorrowForm bookBorrowForm) {
        BookBorrowDto bookBorrowDto = MapperUtils.map(bookBorrowForm,BookBorrowDto.class);
        bookAssembleService.borrow(bookBorrowDto);
        return ResponseCode.SUCCESS;
    }

    @RequestMapping("/returnBack")
    public ResponseCode returnBack(@RequestBody BookReturnBackForm bookReturnBackForm) {
        bookAssembleService.returnBack(bookReturnBackForm.getUserId(), bookReturnBackForm.getIsbn());
        return ResponseCode.SUCCESS;
    }
}
