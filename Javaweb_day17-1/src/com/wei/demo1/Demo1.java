package com.wei.demo1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo1 {

    /*
    * ClassNotFoundException：
    * 抛出这个异常的话有可能是我们的类名称打错了
    * 也有可能我们的包没有导就是那个MySQL的驱动包没有到
    *
    *
    * SQLException：
    * 这个可能是MySQL关闭了我们最好检查一下数据库是否开启了net start mysql开启一下
    * 还有就是检查url, username, password是否错误
    *
    * */

    @Test
    public void fun1() throws ClassNotFoundException, SQLException {
        //加载驱动类,这个加载驱动类是定死了的了的，就是使用这个方法Class.forName("类名称");
        //com.mysql.jdbc.Driver
        Class.forName("com.mysql.jdbc.Driver");
        //连接url，username,password到对象
        String url = "jdbc:mysql://localhost:3306/mydb2";//这个是连接数据库的路径
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);

        System.out.printf(String.valueOf(connection));


    }

}
