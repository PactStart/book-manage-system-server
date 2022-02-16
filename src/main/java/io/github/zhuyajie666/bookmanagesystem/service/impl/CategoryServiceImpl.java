package io.github.zhuyajie666.bookmanagesystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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

import java.util.Comparator;
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
    public List<CategoryVo> getCategoryTree() {
        List<Category> categories = categoryMapper.selectAll();
        List<CategoryVo> categoryVos = MapperUtils.mapList(categories, CategoryVo.class);
        Map<Integer,List<CategoryVo>> parentMap = Maps.newHashMap();
        categoryVos.forEach(categoryVo -> {
            if(parentMap.containsKey(categoryVo.getPid())) {
                parentMap.get(categoryVo.getPid()).add(categoryVo);
            } else {
                parentMap.put(categoryVo.getPid(), Lists.newArrayList(categoryVo));
            }
        });
        parentMap.forEach((Integer key,List<CategoryVo> values) -> {
            values.sort(new Comparator<CategoryVo>() {
                @Override
                public int compare(CategoryVo o1, CategoryVo o2) {
                    return o1.getSort() - o2.getSort();
                }
            });
        });
        List<CategoryVo> rootNodes = parentMap.get(0);
        buildTree(rootNodes,parentMap);
        return rootNodes;
    }

    @Override
    public CategoryVo getById(Integer id) {
        Category category = categoryMapper.selectByPrimaryKey(id);
        return MapperUtils.map(category,CategoryVo.class);
    }

    private void buildTree(List<CategoryVo> nodes,Map<Integer,List<CategoryVo>> parentMap) {
        nodes.forEach(node -> {
            List<CategoryVo> children = parentMap.get(node.getId());
            if(children != null && children.size() > 0) {
                buildTree(children,parentMap);
            }
            node.setChildren(children);
        });
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }

}
