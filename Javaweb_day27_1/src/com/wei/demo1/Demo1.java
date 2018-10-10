package com.wei.demo1;

@MyAnn(age = 100, name = "张三")
public class Demo1 {

    @MyAnn(age = 100, name = "张三")
    private String name;

    @MyAnn(age = 100, name = "张三")
    public void fun1(){

        @MyAnn(age = 100, name = "张三")
        String name = null;

        System.out.println(name);
    }

    @MyAnn(age = 100, name = "张三")
    /**
     *
     * 构造器
     */
    public Demo1(){

    }

    /**
     * 有参构造
     * @param name
     */
    public Demo1(@MyAnn(age = 100, name = "张三") String name){

    }
}

@interface MyAnn{
    //主机的定义
    int age ();
    String name();

}

@interface MyAnn2{
    //注释默认值
    int age() default 100;
    String name();
}