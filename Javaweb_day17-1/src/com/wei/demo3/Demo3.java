package com.wei.demo3;

import org.junit.Test;

import java.sql.*;

public class Demo3 {

    /*
    *
    * 我们使用PreparedStatement这个类我们用来校验一个sql语句的正确与否
    * */
    public boolean login(String username, String password) throws Exception{

        /**
         * 配置四大参数
         */
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String myUsername = "root";
        String myPassword = "root";

        //驱动类
        Class.forName(driverClassName);
        
        
        //连接数据库
        Connection con = DriverManager.getConnection(url, myUsername, myUsername);

        //给出Sql模板
        String sql = "SELECT * FROM t_user WHERE username=? and password=?";
        
        //调用con里面的prepareStaatement(sql)
        PreparedStatement ppst = con.prepareStatement(sql);


        //调用ppst里面的setXxx方法
        ppst.setString(1, username);
        ppst.setString(2, password);

        ResultSet rs = ppst.executeQuery();

        System.out.println();


        return rs.next();
    }

    @Test
    public void fun1() throws Exception {

        String username = "张三";
        String password = "123";
        boolean login = login(username, password);
        System.out.println(login);

    }

    @Test
    public void fun3() throws SQLException {
        Connection con = JdbcUtils.getConnection();
        System.out.println(con);
        Connection con2 = JdbcUtils.getConnection();
        System.out.println(con2);
    }
}
