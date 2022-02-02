package io.github.zhuyajie666.bookmanagesystem.service;

import io.github.zhuyajie666.bookmanagesystem.dto.UserBorrowLogQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.UserBorrowLog;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import io.github.zhuyajie666.bookmanagesystem.vo.UserVo;

public interface UserBorrowLogService {

    void add(UserBorrowLog userBorrowLog);

    PageResult<UserVo> query(UserBorrowLogQueryDto UserBorrowLogQueryDto);

    void update(UserBorrowLog userBorrowLog);

    UserBorrowLog getNotYetReturnBackLog(Integer userId, String isbn);
}
