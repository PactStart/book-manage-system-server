package io.github.zhuyajie666.bookmanagesystem.service;

import io.github.zhuyajie666.bookmanagesystem.dao.UserDao;
import io.github.zhuyajie666.bookmanagesystem.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class UserService {

    private static UserDao userDao = null;

    @BeforeAll
    public static void init() {
        userDao = new UserDao();
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setEmail("1203208955@qq.com");
        user.setPhone("15002080164");
        user.setPassword("123456");
        user.setCreateAt(new Date());
        user.setUpdateAt(new Date());
        userDao.insert(user);
    }
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(2);
        user.setEmail("120etwert3208955@qq.com");
        user.setPhone("15002080166");
        user.setPassword("1234567");
        user.setCreateAt(new Date());
        user.setUpdateAt(new Date());
        userDao.update(user);
    }
    @Test
    public void testDelete(){
        Integer userId = 9;
        userDao.delete(userId);
    }
    @Test
    public void testFindById(){
        Integer userId=2;
        User user = userDao.findById(userId);
        System.out.println(user.getEmail());
        System.out.println(user.getPhone());
    }
    @Test
    public void testFindAll(){
        List<User> userList = userDao.findAll();
        System.out.println(userList.size());
    }


}
