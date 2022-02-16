package io.github.zhuyajie666.bookmanagesystem.dao;

import io.github.zhuyajie666.bookmanagesystem.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper extends Mapper<User> {

    @Update("update user set del = 1 where id = #{id}")
    void tagDelete(@Param("id") Integer id);

    @Select("select * from user where phone = #{phone}")
    User selectOneByPhone(@Param("phone") String phone);

    @Select("select * from user where email = #{email}")
    User selectOneByEmail(@Param("email") String email);

    List<User> query(Map<String, Object> condition);

    @Select("select count(1) from manager where del = 0")
    int selectUnDelCount();
}