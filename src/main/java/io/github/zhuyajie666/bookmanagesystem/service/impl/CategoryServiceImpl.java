package io.github.zhuyajie666.bookmanagesystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.zhuyajie666.bookmanagesystem.dao.CategoryMapper;
import io.github.zhuyajie666.bookmanagesystem.dto.CategoryQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.Category;
import io.github.zhuyajie666.bookmanagesystem.service.CategoryService;
import io.github.zhuyajie666.bookmanagesystem.utils.BeanMapUtils;
import io.github.zhuyajie666.bookmanagesystem.utils.MapperUtils;
import io.github.zhuyajie666.bookmanagesystem.utils.PageUtils;
import io.github.zhuyajie666.bookmanagesystem.vo.CategoryVo;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageResult<CategoryVo> query(CategoryQueryDto categoryQueryDto) {
        Map<String, Object> condition = BeanMapUtils.beanToMap(categoryQueryDto);
        Page<Category> page = PageHelper.startPage(categoryQueryDto.getPageNum(), categoryQueryDto.getPageSize())
                .doSelectPage(() -> categoryMapper.query(condition));
        return PageUtils.convert(page, CategoryVo.class);
    }

    @Override
    public List<CategoryVo> getByPid(Integer pid) {
        List<Category> categories = categoryMapper.selectByPid(pid);
        return MapperUtils.mapList(categories, CategoryVo.class);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }


}
