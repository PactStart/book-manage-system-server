package io.github.zhuyajie666.bookmanagesystem.utils;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import io.github.zhuyajie666.bookmanagesystem.entity.Book;
import io.github.zhuyajie666.bookmanagesystem.vo.BookVo;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;

public class PageUtils {

    public static <E,T> PageResult<T> convert(Page<E> page,Class<T> clazz) {
        boolean hasPreviousPage = 1 < page.getPageNum() && page.getPages() > 0;
        boolean hasNextPage = page.getPageNum() < page.getPages();

        return new PageResult(page.getPageNum(),page.getPages()
        , (int) page.getTotal(),hasPreviousPage,hasNextPage,MapperUtils.mapList(page.getResult(),clazz));

    }

    public static PageResult newEmptyPageResult() {
        return new PageResult(1,10
                , 0,false,false, Lists.newArrayList());

    }

    public static <E,T> PageResult<BookVo> newSinglePageResult(E e,Class<T> clazz) {
        return new PageResult(1,10
                , 1,false,false, Lists.newArrayList(MapperUtils.map(e,clazz)));
    }
}
