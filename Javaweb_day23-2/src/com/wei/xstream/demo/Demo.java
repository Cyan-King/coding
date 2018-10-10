package com.wei.xstream.demo;

import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public List<Province> getProvince(){
        Province p1 = new Province();
        p1.setName("江西");
        p1.addCity(new City("丰城", "FengCheng"));
        p1.addCity(new City("南昌", "NanChang"));

        Province p2 = new Province();
        p2.setName("山西");
        p2.addCity(new City("咸阳", "XianYang"));
        p2.addCity(new City("西山", "XiShan"));

        List<Province> provinceList = new ArrayList<Province>();
        provinceList.add(p1);
        provinceList.add(p2);

        return provinceList;
    }

    @Test
    public void fun1(){

        List<Province> proList = getProvince();
        XStream xStream = new XStream();

        String s = xStream.toXML(proList);
        System.out.println(s);

    }

    @Test
    public void fun2(){
        List<Province> provinceList = getProvince();

        XStream xStream = new XStream();
        //给指定的类型命名
        xStream.alias("china", List.class);//给List类型指定别名为china
        xStream.alias("province", Province.class);//给Province类型指定别名provnice
        xStream.alias("city", City.class);//给City类型指定别名city

        //给Provnice类型的name属性，生成到<Province>的name属性名
        xStream.useAttributeFor(Province.class, "name");
        //去除Provice类的名为cities的List类型的属性！
        xStream.addImplicitCollection(Province.class, "cities");

//        xStream.omitField(City.class, "name");
        xStream.useAttributeFor(City.class, "name");



        String s = xStream.toXML(provinceList);
        System.out.println(s);
    }
}
