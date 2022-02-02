package io.github.zhuyajie666.bookmanagesystem.service;

import io.github.zhuyajie666.bookmanagesystem.dto.ManagerQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.Manager;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import io.github.zhuyajie666.bookmanagesystem.vo.UserVo;

public interface ManagerService {
    void add(Manager manager);

    void update(Manager manager);

    void delete(Integer id);

    Manager findById(Integer id);

    Manager findByPhone(String phone);

    Manager findByEmail(String email);

    PageResult<UserVo> query(ManagerQueryDto managerQueryDto);

}
