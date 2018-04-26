package com.test.UtilTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args){

        //先创建Set集合
        /*set集合的两个特点点：
        * 1.set集合是无序的
        * 2.set集合中的元素是不重复的
        *
        * */
        Set<String> set = new HashSet<String>();
        set.add("aaaaa");
        set.add("bbbbb");
        set.add("ccccc");
        set.add("aaaaa");

        //set可以使用两种方式来遍历集合
        //第一种使用迭代器来遍历
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("=========================");
        //第二种便利方式使用增强for
        for (String s1:set) {
            System.out.println(s1);
        }
    }
}
