package io.github.zhuyajie666.bookmanagesystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.zhuyajie666.bookmanagesystem.dao.ManagerMapper;
import io.github.zhuyajie666.bookmanagesystem.dto.ManagerQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.Manager;
import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.exception.AppException;
import io.github.zhuyajie666.bookmanagesystem.service.ManagerService;
import io.github.zhuyajie666.bookmanagesystem.utils.BeanMapUtils;
import io.github.zhuyajie666.bookmanagesystem.utils.MapperUtils;
import io.github.zhuyajie666.bookmanagesystem.utils.PageUtils;
import io.github.zhuyajie666.bookmanagesystem.vo.ManagerVo;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public void add(Manager manager) {
        Manager dbManager = findByEmail(manager.getEmail());
        if(dbManager != null) {
            throw new AppException(ResponseCode.EMAIL_EXIST);
        }
        dbManager = findByPhone(manager.getPhone());
        if(dbManager != null) {
            throw new AppException(ResponseCode.PHONE_EXIST);
        }
        if(!StringUtils.hasText(manager.getAvatar())) {
            manager.setAvatar("");
        }
        manager.setCreateAt(new Date());
        manager.setUpdateAt(new Date());
        manager.setDel(false);
        managerMapper.insert(manager);
    }

    @Override
    public void update(Manager manager) {
        managerMapper.updateByPrimaryKeySelective(manager);
    }

    @Override
    public void delete(Integer id) {
        managerMapper.tagDelete(id);
    }

    @Override
    public ManagerVo findById(Integer id) {
        Manager manager = managerMapper.selectByPrimaryKey(id);
        return MapperUtils.map(manager,ManagerVo.class);
    }

    @Override
    public Manager findByPhone(String phone) { return managerMapper.selectOneByPhone(phone);
    }

    @Override
    public Manager findByEmail(String email) {
        return managerMapper.selectOneByEmail(email);
    }

    @Override
    public PageResult<ManagerVo> query(ManagerQueryDto managerQueryDto) {
        Map<String, Object> condition = BeanMapUtils.beanToMap(managerQueryDto);
        Page<Manager> page = PageHelper.startPage(managerQueryDto.getPageNum(),managerQueryDto.getPageSize())
                .doSelectPage( () -> managerMapper.query(condition));
        return PageUtils.convert(page,ManagerVo.class);
    }

    @Override
    public int count() {
        return managerMapper.selectUnDelCount();
    }
}
