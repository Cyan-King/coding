package com.wei.demo;

import com.wei.jdbc.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo1 {

    /**
     *
     * @param from
     * @param to
     * @param money
     */
    public void zhuanzhang(String from, String to, double money){

        Connection  con = null;
        try {
            //连接数据库
            con = JdbcUtils.getConnection();
            //开启事务
            con.setAutoCommit(false);
            //事务过程
            AccountDao dao = new AccountDao();
            dao.UpdateBalance(con, from,-money);//从from这个账户转出想要的金额就是减去
            dao.UpdateBalance(con, to,money);//转入的金额就是加
            //提交事务
            con.commit();
            con.close();
        } catch (SQLException e) {
            try {
                con.rollback();
                con.close();
            } catch (SQLException e1) {

            }
        }
    }

    @Test
    public void fun1(){
        zhuanzhang("zs", "ls", 100);
    }
}
