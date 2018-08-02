package com.wei.user.dao;

import com.wei.user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserDaoImpl implements UserDao {


    @Override
    public User findByUsername(String username) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            /*
             * 一、得到连接
             */
            con = JdbcUtils.getConnection();
            /*
             * 二、准备sql模板，得到pstmt
             */
            String sql = "SELECT * FROM t_user WHERE username=?";
            pstmt = con.prepareStatement(sql);
            /*
             * 三、为pstmt中的问号赋值
             */
            pstmt.setString(1, username);

            /*
             * 四、执行之
             */
            rs = pstmt.executeQuery();

            /*
             * 五、把rs转换成User类型，返回！
             */
            if(rs == null) {
                return null;
            }
            if(rs.next()) {
                //转换成User对象，并返回
                // ORM --> 对象关系映射！ hibernate!
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
                user.setLove(rs.getString("love"));


                return user;
            } else {
                return null;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch(SQLException e) {}
        }
    }





    @Override
    public void add(User user) {

        Connection con = null;
        PreparedStatement prst = null;

        /*
        * 对数据库进行操作
        * */

        try {
            /**
             * 进行数据库连接
             */
            con = JdbcUtils.getConnection();

            //准备sql模板
            String sql = "INSERT INTO t_user VALUES(?,?,?,?,?)";

            //PreparedStatement调用这个类
             prst = con.prepareStatement(sql);

            //prst给问号赋值
            prst.setString(1, user.getUsername());
            prst.setString(2, user.getPassword());
            prst.setInt(3, user.getAge());
            prst.setString(4, user.getSex());
            prst.setString(5, user.getLove());

            //执行sql语句
            prst.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();;
                if (prst != null) prst.close();
            } catch (SQLException e){ }
        }
    }
}
