package com.wei.demo2;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class Demo2 {

    @Test
    public void fun1(){
        //作用目标
        Class<A> c = A.class;
        //获取指定类型注解
        MyAnno1 myAnno = c.getAnnotation(MyAnno1.class);
        System.out.printf(myAnno.name() + ", " + myAnno.age() + ", " + myAnno.sex());
    }

    @Test
    public void fun2() throws NoSuchMethodException {
        //得到作用目标
        Class<A> c = A.class;
        Method method = c.getMethod("fun");

        //获取指定类型注解
        MyAnno1 myAnno = method.getAnnotation(MyAnno1.class);
        System.out.printf(myAnno.name() + ", " + myAnno.age() + ", " + myAnno.sex());
    }
}

@MyAnno1(name = "Jack", age = 1, sex = "男")
class A{
    @MyAnno1(name = "Mikl", age = 2, sex = "女")
    public void fun(){

    }
}
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno1{
    String name();
    int age();
    String sex();
}
