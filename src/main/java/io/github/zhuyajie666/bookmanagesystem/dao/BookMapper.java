package io.github.zhuyajie666.bookmanagesystem.dao;

import io.github.zhuyajie666.bookmanagesystem.entity.Book;
import io.github.zhuyajie666.bookmanagesystem.entity.model.BookCount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BookMapper extends Mapper<Book> {

    @Update("update book set del = 1 where id = #{id}")
    void tagDelete(@Param("id") Integer id);

    List<Book> query(Map<String, Object> condition);

    @Select("select count(1) from book where category_id = #{categoryId} and del = 0")
    int selectCountByCategoryId(@Param("categoryId") Integer categoryId);

    @Update("update book set remain_inventory = remain_inventory - #{num} where id = #{id} and remain_inventory >= #{num}")
    int subtractInventory(@Param("id") Integer id, @Param("num") Integer num);

    @Update("update book set inventory = inventory + #{num}, remain_inventory = remain_inventory + #{num} where id = #{id}")
    void addInventory(@Param("id") Integer id, @Param("num") Integer num);

    BookCount queryStatisticInfo();
}