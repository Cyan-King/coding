package com.test.UtilTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {

    public static void main(String[] args){

        //Map集合是键值对集合
        Map<String, String> map = new HashMap<String, String>();
        //Map集合添加元素使用put添加的
        map.put("1111", "赵一");
        map.put("2222", "钱二");
        map.put("3333", "孙三");
        map.put("1111", "李四");
        //Map集合两种遍历方式
        //第一种方式：获取所有的key，通过用key的到value使用get()方法输出
        Set<String> sets = map.keySet();
        for (String key:sets) {
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }
        System.out.println("======================");
        //第二种方法获取key和value的关系---我们使用entrySet()方法
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> s1 : entries) {
//            System.out.println(key);
            String key = s1.getKey();
            String value = s1.getValue();
            System.out.println(key + ":" + value);

        }
    }
}
