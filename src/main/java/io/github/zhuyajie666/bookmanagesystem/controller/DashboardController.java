package io.github.zhuyajie666.bookmanagesystem.controller;

import io.github.zhuyajie666.bookmanagesystem.entity.model.BookCount;
import io.github.zhuyajie666.bookmanagesystem.entity.model.UserBorrowLogCount;
import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.form.BookSaveForm;
import io.github.zhuyajie666.bookmanagesystem.service.BookService;
import io.github.zhuyajie666.bookmanagesystem.service.ManagerService;
import io.github.zhuyajie666.bookmanagesystem.service.UserBorrowLogService;
import io.github.zhuyajie666.bookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserBorrowLogService userBorrowLogService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public ResponseCode index(@RequestBody BookSaveForm bookSaveForm, HttpServletRequest request) {
        BookCount bookCount = bookService.count();
        UserBorrowLogCount userBorrowLogCount = userBorrowLogService.count();
        int managerCount = managerService.count();
        int userCount = userService.count();

        Map<String,Object> data = new HashMap<>();
        data.put("bookCount",bookCount);
        data.put("userBorrowLogCount",userBorrowLogCount);
        data.put("managerCount",managerCount);
        data.put("userCount",userCount);
        return ResponseCode.build(data);
    }


}
