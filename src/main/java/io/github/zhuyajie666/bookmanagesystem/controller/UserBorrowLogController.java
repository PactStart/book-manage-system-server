package io.github.zhuyajie666.bookmanagesystem.controller;

import io.github.zhuyajie666.bookmanagesystem.dto.UserBorrowLogQueryDto;
import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.form.UserBorrowLogQueryForm;
import io.github.zhuyajie666.bookmanagesystem.service.UserBorrowLogService;
import io.github.zhuyajie666.bookmanagesystem.utils.MapperUtils;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import io.github.zhuyajie666.bookmanagesystem.vo.UserBorrowLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userBorrowLog")
public class UserBorrowLogController {

    @Autowired
    private UserBorrowLogService userBorrowLogService;

    @RequestMapping("/query")
    public ResponseCode query(@RequestBody UserBorrowLogQueryForm userBorrowLogQueryForm) {
        UserBorrowLogQueryDto userBorrowLogQueryDto = MapperUtils.map(userBorrowLogQueryForm, UserBorrowLogQueryDto.class);
        PageResult<UserBorrowLogVo> pageResult = userBorrowLogService.query(userBorrowLogQueryDto);
        return ResponseCode.build(pageResult);
    }

}
