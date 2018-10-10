package com.wei.demo1;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo1 {


    /**
     * 这个c3p0属于手动的配置文件，又叫代码连接
     * @throws PropertyVetoException
     * @throws SQLException
     */
    @Test
    public void fun1() throws PropertyVetoException, SQLException {
        //创建c3p0数据池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        //配置参数
        dataSource.setDriverClass("jdbc.mysql.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb3");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        //连接数据库的到connection
        Connection con = dataSource.getConnection();

        System.out.println(con);

        con.close();
    }


    /**
     * 自动配置因为，之前已经约定到了配置文件的名字和存放位置
     * @throws SQLException
     */
    @Test
    public void fun2() throws SQLException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        Connection con = dataSource.getConnection();

        System.out.println(con);

        con.close();
    }

    /**
     * 使用命名配置信息
     * @throws SQLException
     */
    public void fun3() throws SQLException {
        /**
         * 构造参数指定配置参数
         */
        ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle-config");

        Connection con = dataSource.getConnection();

        System.out.println(con);

        con.close();
    }
}
