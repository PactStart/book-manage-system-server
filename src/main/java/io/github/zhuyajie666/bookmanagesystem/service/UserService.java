package io.github.zhuyajie666.bookmanagesystem.service;

import io.github.zhuyajie666.bookmanagesystem.dto.UserQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.User;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import io.github.zhuyajie666.bookmanagesystem.vo.UserVo;

public interface UserService {

    void add(User user);

    void update(User user);

    void delete(Integer id);

    User getById(Integer id);

    UserVo findById(Integer id);

    User findByPhone(String phone);

    User findByEmail(String email);

    PageResult<UserVo> query(UserQueryDto userQueryDto);

    int count();

}
