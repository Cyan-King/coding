package com.dom4j;

import org.dom4j.Document;
import org.dom4j.Element;

import java.util.List;

public class TestDom4jGet {

    public static void main(String[] args){

        GetName1();
    }

    private static void GetName1() {
        //获取到document
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //获取根节点
        Element rootElement = document.getRootElement();
        //获取所有的p1节点
        List<Element> list = rootElement.elements("p1");
        //获取指定的p1节点
        Element p1 = list.get(0);
        //获取p1的属性值
        String s = p1.attributeValue("id");

        System.out.println(s);
    }
}
