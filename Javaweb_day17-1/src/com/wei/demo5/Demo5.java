package com.wei.demo5;

import com.wei.demo3.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo5 {

    @Test
    public void fun5() throws SQLException {


        //连接数据库
        Connection con = JdbcUtils.getConnection();

        //创建sql模板
        String sql = "INSERT INTO t_user VALUES(?,?,?,?,?)";

        PreparedStatement pspt = con.prepareStatement(sql);


        for (int i = 0; i <= 10000; i++){
            pspt.setString(1, "stu_" + 1);
            pspt.setString(2, "ps"+i);
            pspt.setInt(3, i);
            pspt.setString(4, i%2==0?"男":"女");
            pspt.setString(5, "lo" + i);

            //添加批
            pspt.addBatch();
        }

        long start = System.currentTimeMillis();
        pspt.executeBatch();
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
