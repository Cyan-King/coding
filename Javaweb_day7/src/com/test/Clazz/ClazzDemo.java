package com.test.Clazz;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClazzDemo {

    //反射获取属性
    @Test
    public void Test1() throws Exception {

        //得到class
        Class c1 = Class.forName("com.test.Clazz.Person");
        //实例person
        Person p1 = (Person) c1.newInstance();
        //使用Field方法获取属性
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "liu");
        System.out.println(name.get(p1));
    }

    //有参构造
    @Test
    public void Test2() throws  Exception{
        //得到class
        Class c2 = Class.forName("com.test.Clazz.Person");
        //获取有参构造
        Constructor c22 = c2.getConstructor(String.class, String.class, String.class);
        //进行构造
        Person p2 = (Person) c22.newInstance("1", "wei", "2");
        System.out.println(p2.getId()+ ":" + p2.getName() + ":" + p2.getAge());
    }

    //无参构造
    @Test
    public void Test3() throws  Exception{

        //得到class
        Class c3 = Class.forName("com.test.Clazz.Person");
        //得到Person
        Person p3 = (Person) c3.newInstance();
        //通过set方法给里面赋值
        p3.setAge("112");
        p3.setName("wu");
        System.out.println(p3.getAge());
    }

    //操作Method方法
    @Test
    public void Test4() throws  Exception{

        //得到class
        Class c4 = Class.forName("com.test.Clazz.Person");
        //得到Person
        Person p4 = (Person) c4.newInstance();
        //获取方法
        Method m1 = c4.getDeclaredMethod("setName", String.class);
        //放开私有化权限
        m1.setAccessible(true);
        //使用
        m1.invoke(p4, "hhhh");
        System.out.println(p4.getName());

    }
}
