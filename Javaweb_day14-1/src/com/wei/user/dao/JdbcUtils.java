package com.wei.user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {


    private static Properties propes = null;
    static {
        try {
        //加载配置文件
        InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
        propes = new Properties();
        propes.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //加载驱动类
        try {
            Class.forName(propes.getProperty("driverClassName"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() throws SQLException {

        //得到Connection类
        return DriverManager.getConnection(propes.getProperty("url"),
                propes.getProperty("username"),
                propes.getProperty("password"));

    }
}
