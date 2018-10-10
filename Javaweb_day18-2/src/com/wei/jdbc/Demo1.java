package com.wei.jdbc;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo1 {


    /**
     * 连接线程池
     * 1.创建池对象，使用DataSoure接口
     * 2. 四大池配置参数
     * 3. 池参数
     * 4.连接池对象
     */
    @Test
    public void fun1() throws SQLException {

        //创建池对象
        BasicDataSource dataSource = new BasicDataSource();

        //配置四大池参数
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb3");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //池参数
        dataSource.setMaxActive(20);
        dataSource.setMaxIdle(12);
        dataSource.setMinIdle(3);
        dataSource.setMaxWait(1000);

        //连接池对象
        Connection con = dataSource.getConnection();
        Connection con1 = new MyConnection(con);

        System.out.println(con1.getClass().getName());

        con1.close();

    }
}
