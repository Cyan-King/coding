package com.wei.thread;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Demo1 {

    @Test
    public void fun1(){
        ThreadLocal<String> tl = new ThreadLocal<String>();

        //这是一个存的动作
        tl.set("hehehe");
        //这个一个取的动作
//        String s = tl.get();
        //删除的动作
        tl.remove();
//        System.out.println(s);

        new Thread(){
            @Override
            public void run() {
                //在其他线程中是拿不到的，只有在它自己线程中是拿的到的
                String s1 = tl.get();
                System.out.println("内部类："+s1);
            }
        }.start();

    }

    @Test
    public void fun2(){
        Map<Thread, String> map = new HashMap<Thread, String>();
        map.put(Thread.currentThread(), "hello");
        String s = map.get(Thread.currentThread());
        System.out.println(s);

        new Thread(){
            @Override
            public void run() {
                System.out.println(map.get(Thread.currentThread()));
            }
        }.start();
    }
}
