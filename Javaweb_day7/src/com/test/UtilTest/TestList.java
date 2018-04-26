package com.test.UtilTest;

import java.util.ArrayList;
import java.util.Iterator;

public class TestList {
    public static void main(String[] args){

        //我们使用泛型来规定数组的数据类型
        ArrayList<String> list = new ArrayList<String>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");
        //实现三种循环
        //第一种普通for循环---在这里我们使用size() 的到list的长度-----使用get()得到list的集合的内容
        for (int i = 0; i < list.size(); i++){
            String s = list.get(i);
            System.out.println(s);
        }
        System.out.println("=====================");
        //第二种增强for循环
        for (String s1:list) {
            System.out.println(s1);
        }
        System.out.println("=====================");
        //第三种使用迭代器遍历
        //使用迭代器类Iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
