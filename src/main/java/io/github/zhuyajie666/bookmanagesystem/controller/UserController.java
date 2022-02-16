package io.github.zhuyajie666.bookmanagesystem.controller;

import io.github.zhuyajie666.bookmanagesystem.component.TokenManager;
import io.github.zhuyajie666.bookmanagesystem.dto.UserQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.Manager;
import io.github.zhuyajie666.bookmanagesystem.entity.User;
import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.form.IdForm;
import io.github.zhuyajie666.bookmanagesystem.form.ManagerSaveForm;
import io.github.zhuyajie666.bookmanagesystem.form.UserQueryForm;
import io.github.zhuyajie666.bookmanagesystem.form.UserSaveForm;
import io.github.zhuyajie666.bookmanagesystem.service.UserService;
import io.github.zhuyajie666.bookmanagesystem.utils.MapperUtils;
import io.github.zhuyajie666.bookmanagesystem.vo.ManagerVo;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import io.github.zhuyajie666.bookmanagesystem.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManager tokenManager;

    @RequestMapping("/add")
    public ResponseCode add(@RequestBody UserSaveForm userSaveForm/*, HttpServletRequest request*/) {
     /*   String token = request.getHeader("token");
        if(token == null) {
            return ResponseCode.NOT_YET_LOGIN;
        }
        Manager manager = tokenManager.getByToken(token);
        if(manager == null) {
            return ResponseCode.NOT_YET_LOGIN;
        }*/

        User user = MapperUtils.map(userSaveForm,User.class);
        userService.add(user);
        return ResponseCode.SUCCESS;
    }

    @RequestMapping("/getById")
    public ResponseCode getById(@RequestBody IdForm idForm) {
        UserVo userVo = userService.findById(idForm.getId());
        return ResponseCode.build(userVo);
    }

    @RequestMapping("/update")
    public ResponseCode update(@RequestBody UserSaveForm userSaveForm) {
        User user = MapperUtils.map(userSaveForm, User.class);
        userService.update(user);
        return ResponseCode.SUCCESS;
    }

    @RequestMapping("/query")
    public ResponseCode query(@RequestBody UserQueryForm userQueryForm) {
        UserQueryDto userQueryDto = MapperUtils.map(userQueryForm, UserQueryDto.class);
        PageResult<UserVo> pageResult = userService.query(userQueryDto);
        return ResponseCode.build(pageResult);
    }

    @RequestMapping("/delete")
    public ResponseCode delete(@RequestBody IdForm idForm) {
        userService.delete(idForm.getId());
        return ResponseCode.SUCCESS;
    }
}
