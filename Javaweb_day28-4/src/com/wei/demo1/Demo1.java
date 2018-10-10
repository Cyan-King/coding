package com.wei.demo1;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo1 {

    @Test
    public void fun1(){
        /**
         * 三大参数
         * 1. ClassLoader
         * 2. Class [] interface--要实现的几口
         * 3. InvocationHandler---它是调节处理器
         */
        ClassLoader loader = this.getClass().getClassLoader();
        Class[] interfaces = {A.class, B.class};
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("您好动态代理！");
                return null;
            }
        };

        //使用三大参数创建代理对象
        Object o = Proxy.newProxyInstance(loader, interfaces, h);

        //强行转型成功
        A a = (A) o;
        B b = (B) o;

        a.a();
        a.aa();
        b.b();
        b.bb();

    }
}

interface A{
    public void a();
    public void aa();
}

interface B{
    public void b();
    public void bb();
}