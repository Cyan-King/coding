package com.wei.demo2;

import org.junit.Test;

import java.sql.*;

public class Demo2 {
    /*
    *
    * 实现数据库的增删改操作
    * */
    @Test
    public void fun1() throws ClassNotFoundException, SQLException {
        /*
        * 先把四大配置参数写出来
        * */
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password="root";

        //调用驱动类
        Class.forName(driverClassName);

        //使用DriverManager.getConnection()连接数据库
        Connection con = DriverManager.getConnection(url, username, password);

        //通过Connection对象的CreateStatement()方法创建Statement对象
        Statement stat = con.createStatement();

        //创建表的操作
        /*String sql = "CREATE TABLE stu(\n" +
                " id INT(11) PRIMARY KEY AUTO_INCREMENT,\n" +
                " NAME VARCHAR(50),\n" +
                " age INT,\n" +
                " sex VARCHAR(50)\n" +
                ");";*/

        //添加插入的操作
//        String sql = "INSERT INTO stu VALUES(NULL, '秋发根', 79, '男')";

        //修改操作
        String sql = "UPDATE stu SET id='4' WHERE name='秋发根'";

        //删除操作
//        String sql = "DELETE FROM stu WHERE id=4";

        //通过Statement对象executeUpdate()来发送sql语句
        int i = stat.executeUpdate(sql);

        System.out.println(i);

        con.close();
        stat.close();
    }


    /*
    * 进行查询操作
    * */
    @Test
    public void fun2() throws ClassNotFoundException, SQLException {
        /*
        * 四大配置信息
        * driverClassName:
        * url
        * username
        * password
        * */

        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "root";

        //驱动类
        Class.forName(driverClassName);

        //使用Connection对象的DriverManager.getConnection()来连接数据库
        Connection con = DriverManager.getConnection(url, username, password);

        //通过Connection对象创建Statement-----con.createStatement---Statement是一个sql语句发送机制
        Statement stat = con.createStatement();

        String sql = "SELECT * FROM stu";

        ResultSet res = stat.executeQuery(sql);

        while (res.next()){
            int id = res.getInt("id");
            String name = res.getString("name");
            int age = res.getInt("age");
            String sex = res.getString("sex");

            System.out.println(id + "   " + name + "   " + age + "    " + sex);
        }

    }

    //规范代码
    @Test
    public void fun3() throws ClassNotFoundException, SQLException {
        /**
         * 四大配置参数
         */
        Connection con = null;
        Statement sta = null;
        ResultSet rs = null;
        try {
            String driverClassName = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mydb2";
            String username = "root";
            String password = "root";

            //添加驱动类
            Class.forName(driverClassName);
            //使用DriverManager.getConnection()来连接数据库
            con = DriverManager.getConnection(url, username, password);

            //使用Statement来传输sql语句
            sta = con.createStatement();

            String sql = "SELECT * FROM stu";

            //这个使用来查询的
            rs = sta.executeQuery(sql);
            int count = rs.getMetaData().getColumnCount();

            /*while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");

                System.out.println(id + "   " + name + "   " + age + "  " + sex);
            }*/

            while (rs.next()){
                for (int i = 1; i <= count; i++){
                    System.out.print(rs.getString(i));
                    if (i < count){
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }


        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {

            if (con != null) con.close();
            if (sta != null) sta.close();
            if (rs != null) rs.close();

        }

    }
}
