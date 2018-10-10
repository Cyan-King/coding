package com.wei.demo2;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo2 {

    @Test
    public void fun1(){

        Waiter manWaiter = new ManWaiter();//目标类
        /**
         * 三大参数
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class[] interfaces = {Waiter.class};
        InvocationHandler h = new WaiterInvocationHandler(manWaiter);

        Waiter waiterProxy = (Waiter) Proxy.newProxyInstance(classLoader, interfaces, h);

        waiterProxy.service();

    }
}

class WaiterInvocationHandler implements InvocationHandler{

    Waiter waiter;//目标类

    /**
     * 构造函数
     */
    public WaiterInvocationHandler(Waiter waiter){
        this.waiter = waiter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("您好");//进行增强
        waiter.service();
        System.out.println("再见");
        return null;
    }
}