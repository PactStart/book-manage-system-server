package io.github.zhuyajie666.bookmanagesystem.service;

import io.github.zhuyajie666.bookmanagesystem.dto.ManagerQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.Manager;
import io.github.zhuyajie666.bookmanagesystem.vo.ManagerVo;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;

public interface ManagerService {
    void add(Manager manager);

    void update(Manager manager);

    void delete(Integer id);

    Manager findById(Integer id);

    Manager findByPhone(String phone);

    Manager findByEmail(String email);

    PageResult<ManagerVo> query(ManagerQueryDto managerQueryDto);

}
