package io.github.zhuyajie666.bookmanagesystem.dao;

import io.github.zhuyajie666.bookmanagesystem.entity.UserBorrowLog;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface UserBorrowLogMapper extends Mapper<UserBorrowLog> {
    void query(Map<String, Object> condition);
}