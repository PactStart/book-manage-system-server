package io.github.zhuyajie666.bookmanagesystem.dao;

import io.github.zhuyajie666.bookmanagesystem.entity.UserBorrowLog;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserBorrowLogMapper extends Mapper<UserBorrowLog> {

    List<UserBorrowLog> query(Map<String, Object> condition);
}