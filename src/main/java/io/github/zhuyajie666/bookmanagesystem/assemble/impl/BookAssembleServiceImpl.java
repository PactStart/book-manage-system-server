package io.github.zhuyajie666.bookmanagesystem.assemble.impl;

import io.github.zhuyajie666.bookmanagesystem.assemble.BookAssembleService;
import io.github.zhuyajie666.bookmanagesystem.dto.BookBorrowDto;
import io.github.zhuyajie666.bookmanagesystem.entity.Book;
import io.github.zhuyajie666.bookmanagesystem.entity.UserBorrowLog;
import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.exception.AppException;
import io.github.zhuyajie666.bookmanagesystem.service.BookService;
import io.github.zhuyajie666.bookmanagesystem.service.CategoryService;
import io.github.zhuyajie666.bookmanagesystem.service.UserBorrowLogService;
import io.github.zhuyajie666.bookmanagesystem.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class BookAssembleServiceImpl implements BookAssembleService {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserBorrowLogService userBorrowLogService;

    private static final BigDecimal BASE_PRICE = new BigDecimal("0.5");

    @Override
    public void deleteCategory(Integer categoryId) {
        int count = bookService.countByCategoryId(categoryId);
        if (count > 0) {
            throw new AppException(ResponseCode.EXIST_BOOK_IN_CATEGORY);
        }
        categoryService.delete(categoryId);
    }

    @Transactional
    @Override
    public void borrow(BookBorrowDto bookBorrowDto) {
        Book book = bookService.getByIsbn(bookBorrowDto.getIsbn());
        if (book == null || book.getDel()) {
            throw new AppException(ResponseCode.BOOK_NOT_EXIST);
        }
        if (book.getRemainInventory() <= 0) {
            throw new AppException(ResponseCode.BOOK_INVENTORY_NOT_ENOUGH);
        }
        boolean isBorrowed = bookService.isBorrowed(bookBorrowDto.getIsbn());
        if(isBorrowed) {
            throw new AppException(ResponseCode.BOOK_HAS_BEEN_BORROWED);
        }
        boolean flag = bookService.borrow(bookBorrowDto.getIsbn());
        if(!flag) {
            throw new AppException(ResponseCode.BOOK_HAS_BEEN_BORROWED);
        }
        boolean success = bookService.subtractInventory(book.getId(), 1);
        if (!success) {
            throw new AppException(ResponseCode.BOOK_INVENTORY_NOT_ENOUGH);
        }
        UserBorrowLog userBorrowLog = new UserBorrowLog();
        userBorrowLog.setUserId(bookBorrowDto.getUserId());
        userBorrowLog.setBookId(book.getId());
        userBorrowLog.setIsbn(bookBorrowDto.getIsbn());
        userBorrowLog.setBorrowAt(new Date());
        userBorrowLog.setBorrowDays(bookBorrowDto.getBorrowDays());
        userBorrowLog.setIsReturn(false);
        userBorrowLog.setReturnAt(new Date());
        userBorrowLog.setOverDays(0);
        userBorrowLog.setFine(BigDecimal.ZERO);
        userBorrowLogService.add(userBorrowLog);

    }

    @Transactional
    @Override
    public void returnBack(Integer userId, String isbn) {
        UserBorrowLog userBorrowLog = userBorrowLogService.getNotYetReturnBackLog(userId, isbn);
        if (userBorrowLog == null) {
            throw new AppException(ResponseCode.BOOK_BORROW_LOG_NOT_EXIST);
        }
        boolean flag = bookService.returnBack(isbn);
        if(!flag) {
            throw new AppException(ResponseCode.BOOK_RETURN_BACK_FAIL);
        }
        LocalDate deadLineReturnBackTime = DateUtils.convert2LocalDate(userBorrowLog.getBorrowAt()).plusDays(userBorrowLog.getBorrowDays());
        LocalDate currentDate = LocalDate.now();
        userBorrowLog.setIsReturn(true);
        userBorrowLog.setReturnAt(new Date());
        if (currentDate.isAfter(deadLineReturnBackTime)) {
            int days = (int) DAYS.between(deadLineReturnBackTime, currentDate);
            days = Math.abs(days);
            userBorrowLog.setFine(BASE_PRICE.multiply(new BigDecimal(days)));
        }
        userBorrowLogService.update(userBorrowLog);
    }
}
