package com.wei.demo;


import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    /**
     * 当map一样的使用
     * @throws JSONException
     */
    @Test
    public void fun1() throws JSONException {

        JSONObject map = new JSONObject();
        map.put("name", "张飞");
        map.put("age", 38);
        map.put("sex", "male");

        System.out.println(map.toString());
    }

    @Test
    public void fun2(){

        Person p = new Person("刘备",21, "female");
        JSONObject map = JSONObject.fromObject(p);

        System.out.println(map.toString());

    }

    @Test
    public void fun3(){

        Person p1 = new Person("貂蝉", 18, "female");
        Person p2 = new Person("甄姬", 21, "female");

        JSONArray list = new JSONArray();
        list.add(p1);
        list.add(p2);

        System.out.println(list.toString());

    }

    @Test
    public void fun4(){

        Person p1 = new Person("貂蝉", 18, "female");
        Person p2 = new Person("甄姬", 21, "female");
        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);

        System.out.println(JSONArray.fromObject(list).toString());

    }

}
