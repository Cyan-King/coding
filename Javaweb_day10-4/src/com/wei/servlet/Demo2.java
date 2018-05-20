package com.wei.servlet;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Demo2 {


    /*
    * 演示classLoader
    * */
    @Test
    public void test1() throws IOException {

        //获取类加载器
        ClassLoader cl = Demo2.class.getClassLoader();
        //使用类加载器在类路径里面查找
        InputStream in = cl.getResourceAsStream("a.html");
        System.out.println(IOUtils.toString(in));

    }

    @Test
    public void test2(){
        Class c = Demo2.class;
        InputStream in = c.getResourceAsStream("a.html");
        try {
            System.out.println(IOUtils.toString(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        Class c = Demo2.class;
        InputStream in = c.getResourceAsStream("/a.html");
        try {
            System.out.println(IOUtils.toString(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
