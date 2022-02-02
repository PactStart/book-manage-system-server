package io.github.zhuyajie666.bookmanagesystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

    static {
        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver load fail",e);
        }
    }

    public static Connection getConnection()  {
        String url = "jdbc:mysql://localhost:3306/book_system";
        String username = "root";
        String password = "123456";
        //2.获取与数据库的链接
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }

}
