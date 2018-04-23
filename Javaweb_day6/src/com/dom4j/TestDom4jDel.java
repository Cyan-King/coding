package com.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.util.List;

public class TestDom4jDel {
    
    public static void main(String[] args){
        /*
        * dom4j删除节点
        * */
     
        Dom4jDel();
    }

    private static void Dom4jDel() {

        //获取docuement
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //获取根节点
        Element rootElement = document.getRootElement();
        //获取p1节点
        List<Element> list = rootElement.elements("p1");
        //获取指定的p1节点---第二个p1节点
        Element p2 = list.get(1);
        //获取p2上的school标签
        List<Element> school2 = p2.elements("school");
        //获取school标签的第一个标签
        Element element = school2.get(0);
        //对这个school2进行删除操作
        p2.remove(element);

        //回写操作
        XMLWriter xmlWriter = Dom4jUtils.xmlWriters(Dom4jUtils.PATH, document);
    }
}
