package com.wei.domain;

import com.wei.util.CommonsUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Demo1 {

    @Test
    public void fun1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        String className = "com.wei.domain.Person";

        //获取路径
        Class clazz = Class.forName(className);
        //反射的路径
        Object bean = clazz.newInstance();

        //使用BeanUtils中的setProperty方法来设置类的属性
        BeanUtils.setProperty(bean, "name", "尹志明");
        BeanUtils.setProperty(bean, "age", "20");
        BeanUtils.setProperty(bean, "sex", "女");

        String sex = BeanUtils.getProperty(bean, "sex");


        System.out.println(bean);
        System.out.println(sex);
    }

    /*
    * 在这里我们使用map集合来设置属性
    * */
    @Test
    public void fun2() throws InvocationTargetException, IllegalAccessException {

        //将map集合中的键值对封装到bean中
        Map<String, String> map = new HashMap<String, String>();

        map.put("userName", "yinzhiming");
        map.put("password", "123");

        User user = new User();

        //这里我们必须要是用BeanUtil了
        BeanUtils.populate(user, map);

        System.out.println(user);

    }

    @Test
    public void fun3() throws Exception{

        Map<String, String> map = new HashMap<String, String>();

        map.put("userName", "yinzhiming");
        map.put("password", "123");

        User user = CommonsUtils.ToBean(map,User.class);

        System.out.println(user);
    }
}
