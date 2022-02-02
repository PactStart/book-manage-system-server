package io.github.zhuyajie666.bookmanagesystem.controller;

import io.github.zhuyajie666.bookmanagesystem.assemble.BookAssembleService;
import io.github.zhuyajie666.bookmanagesystem.dto.CategoryQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.Category;
import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.form.CategoryQueryForm;
import io.github.zhuyajie666.bookmanagesystem.form.CategorySaveForm;
import io.github.zhuyajie666.bookmanagesystem.form.IdForm;
import io.github.zhuyajie666.bookmanagesystem.service.CategoryService;
import io.github.zhuyajie666.bookmanagesystem.utils.MapperUtils;
import io.github.zhuyajie666.bookmanagesystem.vo.CategoryVo;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookAssembleService bookAssembleService;

    @RequestMapping("/add")
    public ResponseCode add(@RequestBody CategorySaveForm categorySaveForm) {
        Category category = MapperUtils.map(categorySaveForm,Category.class);
        categoryService.add(category);
        return ResponseCode.SUCCESS;
    }

    @RequestMapping("/query")
    public ResponseCode query(@RequestBody CategoryQueryForm categoryQueryForm) {
        CategoryQueryDto categoryQueryDto = MapperUtils.map(categoryQueryForm, CategoryQueryDto.class);
        PageResult<CategoryVo> pageResult = categoryService.query(categoryQueryDto);
        return ResponseCode.build(pageResult);
    }

    @RequestMapping("/getByPid")
    public ResponseCode getByPid(@RequestBody IdForm idForm) {
        List<CategoryVo> categoryVoList = categoryService.getByPid(idForm.getId());
        return ResponseCode.build(categoryVoList);
    }

    @RequestMapping("/delete")
    public ResponseCode delete(@RequestBody IdForm idForm) {
        bookAssembleService.deleteCategory(idForm.getId());
        return ResponseCode.SUCCESS;
    }
}
