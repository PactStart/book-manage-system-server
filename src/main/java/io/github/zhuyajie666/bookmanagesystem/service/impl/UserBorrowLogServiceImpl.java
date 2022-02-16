package io.github.zhuyajie666.bookmanagesystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.github.zhuyajie666.bookmanagesystem.dao.UserBorrowLogMapper;
import io.github.zhuyajie666.bookmanagesystem.dto.UserBorrowLogQueryDto;
import io.github.zhuyajie666.bookmanagesystem.entity.UserBorrowLog;
import io.github.zhuyajie666.bookmanagesystem.entity.model.UserBorrowLogCount;
import io.github.zhuyajie666.bookmanagesystem.entity.model.UserBorrowLogEx;
import io.github.zhuyajie666.bookmanagesystem.service.UserBorrowLogService;
import io.github.zhuyajie666.bookmanagesystem.utils.BeanMapUtils;
import io.github.zhuyajie666.bookmanagesystem.utils.PageUtils;
import io.github.zhuyajie666.bookmanagesystem.vo.PageResult;
import io.github.zhuyajie666.bookmanagesystem.vo.UserBorrowLogVo;
import io.github.zhuyajie666.bookmanagesystem.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class UserBorrowLogServiceImpl implements UserBorrowLogService {

    @Autowired
    private UserBorrowLogMapper userBorrowLogMapper;

    @Override
    public void add(UserBorrowLog userBorrowLog){
        userBorrowLogMapper.insert(userBorrowLog);
    }

    @Override
    public PageResult<UserBorrowLogVo> query(UserBorrowLogQueryDto userBorrowLogQueryDto) {
        Map<String, Object> condition = BeanMapUtils.beanToMap(userBorrowLogQueryDto);
        Page<UserBorrowLogEx> page = PageHelper.startPage(userBorrowLogQueryDto.getPageNum(),userBorrowLogQueryDto.getPageSize())
                .doSelectPage( () -> userBorrowLogMapper.query(condition));
        return PageUtils.convert(page,UserBorrowLogVo.class);
    }

    @Override
    public void update(UserBorrowLog userBorrowLog) {
        userBorrowLogMapper.updateByPrimaryKeySelective(userBorrowLog);
    }

    @Override
    public UserBorrowLog getNotYetReturnBackLog(Integer userId, String isbn) {
        Example example = new Example(UserBorrowLog.class);
        example.createCriteria().andEqualTo("userId",userId)
                .andEqualTo("isbn",isbn)
                .andEqualTo("isReturn",false);
        List<UserBorrowLog> userBorrowLogs = userBorrowLogMapper.selectByExample(example);
        return userBorrowLogs == null || userBorrowLogs.size() == 0 ? null : userBorrowLogs.get(0);
    }

    @Override
    public UserBorrowLogCount count() {
        return userBorrowLogMapper.queryStatisticInfo();
    }


}
