package com.wei.user.dao;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {

    private static Properties props = null;

    static {
        /*
         * 我们得出一个配置文件
         * */
        try {

            InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
            props = new Properties();
            props.load(in);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static UserDao getUserDao(){



        //得到一个dao实现的对象
        String daoClassName = props.getProperty("com.wei.user.dao.UserDao");

        //通过反射得到对象
        try {
            Class clazz = Class.forName(daoClassName);
            return (UserDao) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}
