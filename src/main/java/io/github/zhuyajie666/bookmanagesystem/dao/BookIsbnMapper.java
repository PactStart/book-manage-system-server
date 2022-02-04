package io.github.zhuyajie666.bookmanagesystem.dao;

import io.github.zhuyajie666.bookmanagesystem.entity.BookIsbn;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookIsbnMapper extends Mapper<BookIsbn>, InsertListMapper<BookIsbn> {

    @Select("select isbn from book_isbn where book_id =#{bookId}")
    List<String> selectIsbnByBookId(@Param("bookId") Integer bookId);

    @Update("update book_isbn set is_borrowed = true where isbn =#{isbn} and is_borrowed = false")
    int updateIsBorrowed2True(@Param("isbn") String isbn);

    @Update("update book_isbn set is_borrowed = false where isbn =#{isbn} and is_borrowed = true")
    int updateIsBorrowed2False(@Param("isbn")String isbn);
}