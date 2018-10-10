package com.wei.demo4;


import com.wei.demo3.JdbcUtils;
import org.junit.Test;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.*;

/**
 * 大数据
 */

public class Demo4 {

    @Test
    public void fun1() throws SQLException, IOException {

        //连接数据库
        Connection con = JdbcUtils.getConnection();

        //得到sql模板
        String sql = "INSERT INTO tab_bin VALUES(?,?,?)";

        PreparedStatement prst = con.prepareStatement(sql);
        //将这个文件转为字节
        byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(new FileInputStream("F:/CodeIOImage/Javaweb-day17/岑宁儿 - 追光者.mp3"));

        Blob blob = new SerialBlob(bytes);

        prst.setInt(1, 1);
        prst.setString(2, "岑宁儿 - 追光者.mp3");
        prst.setBlob(3, blob);;

        prst.executeUpdate();
    }

    @Test
    public void fun2() throws SQLException, IOException {


        //连接数据库与
        Connection con = JdbcUtils.getConnection();

        //得到sql模板
        String sql = "SELECT * FROM tab_bin";

        PreparedStatement prst = con.prepareStatement(sql);

        ResultSet rs = prst.executeQuery();

        while (rs.next()){

            //得到Blob
            Blob date = rs.getBlob("Date");

            //从数据库中拿文件
            InputStream in = date.getBinaryStream();
            OutputStream out = new FileOutputStream("F:/CodeIOImage/Javaweb-day17/copy2.mp3");

            org.apache.commons.io.IOUtils.copy(in, out);

        }


    }
}
