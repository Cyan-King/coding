package com.wei.demo;

import com.wei.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDao {

    /**
     *
     * @param con
     * @param name
     * @param balance
     */
    public void UpdateBalance(Connection con, String name, double balance) {

        try {
            //进行连接操作
            JdbcUtils.getConnection();

            //得到sql模板
            String sql = "UPDATE account SET balance=balance+? where name=?";

            //prst进行数据库操作
            PreparedStatement prst = con.prepareStatement(sql);

            //按照顺序设置sql中的问好
            prst.setDouble(1, balance);
            prst.setString(2, name);

            //执行
            prst.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
