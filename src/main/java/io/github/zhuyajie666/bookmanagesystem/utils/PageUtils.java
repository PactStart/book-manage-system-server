package io.github.zhuyajie666.bookmanagesystem.utils;

import com.github.pagehelper.Page;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;

public class PageUtils {

    public static <E,T> PageResult<T> convert(Page<E> page,Class<T> clazz) {
        boolean hasPreviousPage = 1 < page.getPageNum() && page.getPages() > 0;
        boolean hasNextPage = page.getPageNum() < page.getPages();

        return new PageResult(page.getPageNum(),page.getPages()
        , (int) page.getTotal(),hasPreviousPage,hasNextPage,MapperUtils.mapList(page.getResult(),clazz));

    }
}
