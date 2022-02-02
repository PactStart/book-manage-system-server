package io.github.zhuyajie666.bookmanagesystem.dao;

import io.github.zhuyajie666.bookmanagesystem.entity.User;
import io.github.zhuyajie666.bookmanagesystem.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public void insert(User user) {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert user(email,phone,password,create_at,update_at) values (?,?,?,?,?)");
            ps.setString(1,user.getEmail());
            ps.setString(2,user.getPhone());
            ps.setString(3,user.getPassword());
            ps.setDate(4,new java.sql.Date(user.getCreateAt().getTime()));
            ps.setDate(5,new java.sql.Date(user.getUpdateAt().getTime()));
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(User user) {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update user set email = ? ,phone = ? ,password = ? ,create_at = ? ,update_at= ? where id = ?");
            ps.setString(1,user.getEmail());
            ps.setString(2,user.getPhone());
            ps.setString(3,user.getPassword());
            ps.setDate(4,new java.sql.Date(user.getCreateAt().getTime()));
            ps.setDate(5,new java.sql.Date(user.getUpdateAt().getTime()));
            ps.setInt(6,user.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Integer userId) {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from user where id = ?");
            ps.setInt(1,userId);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User findById(Integer userId) {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from user where id = ?");
            ps.setInt(1,userId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setPhone(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setCreateAt(resultSet.getDate(5));
                user.setUpdateAt(resultSet.getDate(6));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<User> findAll() {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from user");
            ResultSet resultSet = ps.executeQuery();
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setPhone(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setCreateAt(resultSet.getDate(5));
                user.setUpdateAt(resultSet.getDate(6));
                userList.add(user);
            }
            return userList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
