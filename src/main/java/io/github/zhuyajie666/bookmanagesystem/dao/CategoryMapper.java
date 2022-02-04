package io.github.zhuyajie666.bookmanagesystem.dao;

import io.github.zhuyajie666.bookmanagesystem.entity.Category;
import io.github.zhuyajie666.bookmanagesystem.vo.CategoryVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface CategoryMapper extends Mapper<Category> {

    List<Category> query(Map<String, Object> condition);

    @Select("select * from category where pid = #{pid}")
    List<Category> selectByPid(@Param("pid") Integer pid);
}