package com.wei.demo3;

import org.junit.Test;

public class Demo3 {

    @Test
    public void fun1(){
        //得到工厂实例
        ProxyFactory factory = new ProxyFactory();
        //设置目标类
        factory.setTargetObject(new ManWaiter());
        //设置前置增强
        factory.setBeforAdvice(new BeforAdvice() {
            @Override
            public void beforAdvice() {
                System.out.println("还钱！");
            }
        });
        //设置后置增强
        factory.setAfterAdvice(new AfterAdvice() {
            @Override
            public void afterAdvice() {
                System.out.println("不给！");
            }
        });

        //进行代理
        Waiter waiter = (Waiter) factory.createProxy();
        waiter.service();
    }
}
