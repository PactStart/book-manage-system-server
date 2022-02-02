package io.github.zhuyajie666.bookmanagesystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.zhuyajie666.bookmanagesystem.dao.BookIsbnMapper;
import io.github.zhuyajie666.bookmanagesystem.dao.BookMapper;
import io.github.zhuyajie666.bookmanagesystem.dto.BookQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.Book;
import io.github.zhuyajie666.bookmanagesystem.entity.BookIsbn;
import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.exception.AppException;
import io.github.zhuyajie666.bookmanagesystem.service.BookService;
import io.github.zhuyajie666.bookmanagesystem.utils.BeanMapUtils;
import io.github.zhuyajie666.bookmanagesystem.utils.MapperUtils;
import io.github.zhuyajie666.bookmanagesystem.utils.PageUtils;
import io.github.zhuyajie666.bookmanagesystem.utils.PinyinUtils;
import io.github.zhuyajie666.bookmanagesystem.vo.BookVo;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import io.github.zhuyajie666.bookmanagesystem.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookIsbnMapper bookIsbnMapper;

    @Override
    public void add(Book book){
        book.setUrl("");
        book.setPinyin(PinyinUtils.getAllPinyin(book.getName()));
        book.setPinyinAbbr(PinyinUtils.getFirstPinYin(book.getName()));
        book.setCreateAt(new Date());
        book.setUpdateAt(new Date());
        bookMapper.insert(book);
    }
    @Override
    public void update(Book book) {
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public void delete(Integer id) {
        bookMapper.tagDelete(id);
    }

    @Override
    public PageResult<UserVo> query(BookQueryDto bookQueryDto) {
        Map<String, Object> condition = BeanMapUtils.beanToMap(bookQueryDto);
        Page<BookService> page = PageHelper.startPage(bookQueryDto.getPageNum(),bookQueryDto.getPageSize())
                .doSelectPage( () -> bookMapper.query(condition));
        return PageUtils.convert(page,UserVo.class);
    }

    @Override
    public int countByCategoryId(Integer categoryId) {
        return bookMapper.selectCountByCategoryId(categoryId);
    }

    @Override
    public BookVo getById(Integer bookId) {
        Book book = doGetById(bookId);
        BookVo bookVo = MapperUtils.map(book, BookVo.class);
        List<String> isbnList = bookIsbnMapper.selectIsbnByBookId(bookId);
        bookVo.setIsbnList(isbnList);
        return bookVo;
    }

    public Book doGetById(Integer bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public boolean subtractInventory(Integer bookId, int num) {
        int row = bookMapper.subtractInventory(bookId,num);
        return row > 0;
    }

    @Override
    public Book getByIsbn(String isbn) {
        BookIsbn bookIsbn = bookIsbnMapper.selectByPrimaryKey(isbn);
        if(bookIsbn == null) {
            return null;
        }
        Book book = bookMapper.selectByPrimaryKey(bookIsbn.getBookId());
        return book;
    }


    @Transactional
    @Override
    public void addInventory(Integer bookId, List<String> isbnList) {
        Book book = doGetById(bookId);
        if(book == null) {
            throw new AppException(ResponseCode.BOOK_NOT_EXIST);
        }
        List<BookIsbn> bookIsbnList = new ArrayList<>();
        isbnList.stream().forEach(isbn -> {
            BookIsbn bookIsbn = new BookIsbn();
            bookIsbn.setBookId(bookId);
            bookIsbn.setIsbn(isbn);
            bookIsbnList.add(bookIsbn);
        });
        bookIsbnMapper.insertList(bookIsbnList);
        bookMapper.addInventory(bookId, isbnList.size());
    }
}
