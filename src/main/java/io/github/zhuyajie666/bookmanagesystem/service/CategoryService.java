package io.github.zhuyajie666.bookmanagesystem.service;

import io.github.zhuyajie666.bookmanagesystem.dto.CategoryQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.Category;
import io.github.zhuyajie666.bookmanagesystem.vo.CategoryVo;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;

import java.util.List;

public interface CategoryService {

    void add(Category category);

    void update(Category category);

    void delete(Integer id);

    PageResult<CategoryVo> query(CategoryQueryDto categoryQueryDto);

    List<CategoryVo> getByPid(Integer pid);
}
