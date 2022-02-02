package io.github.zhuyajie666.bookmanagesystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.zhuyajie666.bookmanagesystem.dao.UserMapper;
import io.github.zhuyajie666.bookmanagesystem.dto.UserQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.User;
import io.github.zhuyajie666.bookmanagesystem.errcode.ResponseCode;
import io.github.zhuyajie666.bookmanagesystem.exception.AppException;
import io.github.zhuyajie666.bookmanagesystem.service.UserService;
import io.github.zhuyajie666.bookmanagesystem.utils.BeanMapUtils;
import io.github.zhuyajie666.bookmanagesystem.utils.PageUtils;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import io.github.zhuyajie666.bookmanagesystem.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        User dbUser = findByEmail(user.getEmail());
        if(dbUser != null) {
            throw new AppException(ResponseCode.EMAIL_EXIST);
        }
        dbUser = findByPhone(user.getPhone());
        if(dbUser != null) {
            throw new AppException(ResponseCode.PHONE_EXIST);
        }

        user.setCreateAt(new Date());
        user.setUpdateAt(new Date());
        user.setDel(false);
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void delete(Integer id) {
        userMapper.tagDelete(id);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User findByPhone(String phone) {
        return userMapper.selectOneByPhone(phone);
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.selectOneByEmail(email);
    }

    @Override
    public PageResult<UserVo> query(UserQueryDto userQueryDto) {
        Map<String, Object> condition = BeanMapUtils.beanToMap(userQueryDto);
        Page<User> page = PageHelper.startPage(userQueryDto.getPageNum(),userQueryDto.getPageSize())
                .doSelectPage( () -> userMapper.query(condition));
        return PageUtils.convert(page,UserVo.class);
    }

}
