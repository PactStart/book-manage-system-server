package io.github.zhuyajie666.bookmanagesystem.utils;

import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class MapperUtils {

    public static <T, S> List<T> mapList(List<S> source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        List<T> map = new ArrayList<>();

        Mapper bean = SpringContextHolder.getApplicationContext().getBean(Mapper.class);
        for (S s : source) {
            map.add(bean.map(s, clz));
        }
        return map;
    }

    public static <T, S> T map(S source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        Mapper bean = SpringContextHolder.getApplicationContext().getBean(Mapper.class);
        return bean.map(source, clz);
    }

}
