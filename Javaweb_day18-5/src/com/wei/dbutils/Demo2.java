package com.wei.dbutils;

import com.wei.jdbc.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Demo2 {

    @Test
    public void fun1() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSources());
        String sql = "insert into stu values(?,?,?,?)";
        Object[] params = {8, "赵云", 99, "男"};

        qr.update(sql, params);
    }

    /**
     * BeanHandler应用单个
     * @throws SQLException
     */
    @Test
    public void fun2() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSources());
        String sql = "select * from stu where id=?";
        Object[] params ={7};

        Stu stu = qr.query(sql, new BeanHandler<Stu>(Stu.class), params);

        System.out.println(stu);

    }

    /**
     * BeanListHandler多行使用
     * @throws SQLException
     */
    @Test
    public void fun3() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSources());
        String sql = "select * from stu";

        List<Stu> stuList = qr.query(sql, new BeanListHandler<Stu>(Stu.class));

        System.out.println(stuList);
    }


    /**
     * MapHandler--这个单个查看的
     * @throws SQLException
     */
    @Test
    public void fun4() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSources());
        String sql = "select * from stu where id=?";
        Object[] params = {3};

        Map m = qr.query(sql, new MapHandler(), params);

        System.out.println(m);
    }

    @Test
    public void fun5() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSources());
        String sql = "select * from stu";

        List<Map<String, Object>> maps = qr.query(sql, new MapListHandler());

        System.out.println(maps);
    }


    /**
     * ScalarHandler单个查询
     * @throws SQLException
     */
    @Test
    public void fun6() throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSources());
        String sql = "select count(*) from stu";

        Number sc = (Number) qr.query(sql, new ScalarHandler());
        System.out.println(sc);
    }
}
