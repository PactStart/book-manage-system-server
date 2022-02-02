package io.github.zhuyajie666.bookmanagesystem.controller;

import io.github.zhuyajie666.bookmanagesystem.component.TokenManager;
import io.github.zhuyajie666.bookmanagesystem.dto.ManagerQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.Manager;
import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.exception.AppException;
import io.github.zhuyajie666.bookmanagesystem.form.IdForm;
import io.github.zhuyajie666.bookmanagesystem.form.ManagerLoginForm;
import io.github.zhuyajie666.bookmanagesystem.form.ManagerQueryForm;
import io.github.zhuyajie666.bookmanagesystem.form.ManagerSaveForm;
import io.github.zhuyajie666.bookmanagesystem.service.ManagerService;
import io.github.zhuyajie666.bookmanagesystem.utils.MapperUtils;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import io.github.zhuyajie666.bookmanagesystem.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private TokenManager tokenManager;

    @RequestMapping("/login")
    public ResponseCode login(@RequestBody ManagerLoginForm managerLoginForm) {
        Manager manager = null;
        if(managerLoginForm.getAccount().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
            manager = managerService.findByEmail(managerLoginForm.getAccount());
        } else {
            manager = managerService.findByPhone(managerLoginForm.getAccount());
        }
        if(manager == null) {
            throw new AppException(ResponseCode.ACCOUNT_NOT_EXIST);
        }
        if(!managerLoginForm.getPassword().equals(manager.getPassword())) {
            throw new AppException(ResponseCode.PASSWORD_INCORRECT);
        }
        String token = tokenManager.generateToken(manager);
        return ResponseCode.build(token);
    }

    @RequestMapping("/add")
    public ResponseCode add(@RequestBody ManagerSaveForm userSaveForm) {
        Manager manager = MapperUtils.map(userSaveForm,Manager.class);
        managerService.add(manager);
        return ResponseCode.SUCCESS;
    }

    @RequestMapping("/query")
    public ResponseCode query(@RequestBody ManagerQueryForm managerQueryForm) {
        ManagerQueryDto managerQueryDto = MapperUtils.map(managerQueryForm, ManagerQueryDto.class);
        PageResult<UserVo> pageResult = managerService.query(managerQueryDto);
        return ResponseCode.build(pageResult);
    }

    @RequestMapping("/delete")
    public ResponseCode delete(@RequestBody IdForm idForm) {
        managerService.delete(idForm.getId());
        return ResponseCode.SUCCESS;
    }
}
