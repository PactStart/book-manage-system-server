package io.github.zhuyajie666.bookmanagesystem.dao;

import io.github.zhuyajie666.bookmanagesystem.entity.Manager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ManagerMapper extends Mapper<Manager> {

    @Select("select * from manager where email = #{email}")
    Manager selectOneByEmail(@Param("email") String email);

    @Update("update manager set del = 1 where id = #{id}")
    void tagDelete(@Param("id") Integer id);

    @Select("select * from manager where phone = #{phone}")
    Manager selectOneByPhone(@Param("phone") String phone);

    List<Manager> query(Map<String, Object> condition);
}