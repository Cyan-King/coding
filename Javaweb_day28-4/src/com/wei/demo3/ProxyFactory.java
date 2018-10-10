package com.wei.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 工厂类
 */
public class ProxyFactory {
    private Object targetObject;
    private BeforAdvice beforAdvice;
    private AfterAdvice afterAdvice;


    public Object createProxy(){

        /**
         * 三大参数
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        //得到这个类的所有接口
        Class[] interfaces = targetObject.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                //执行前置增强
                if (beforAdvice != null){
                    beforAdvice.beforAdvice();
                }




                //执行目标方法
                Object result = method.invoke(targetObject, args);

                //执行后置增强
                if (afterAdvice != null){
                    afterAdvice.afterAdvice();
                }

                return result;
            }
        };

        //得到代理对象
        Object proxyObject = Proxy.newProxyInstance(classLoader, interfaces, h);


        return proxyObject;
    }


    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public BeforAdvice getBeforAdvice() {
        return beforAdvice;
    }

    public void setBeforAdvice(BeforAdvice beforAdvice) {
        this.beforAdvice = beforAdvice;
    }

    public AfterAdvice getAfterAdvice() {
        return afterAdvice;
    }

    public void setAfterAdvice(AfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }
}

