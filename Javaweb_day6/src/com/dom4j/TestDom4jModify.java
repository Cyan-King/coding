package com.dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.util.List;

public class TestDom4jModify {
    public static void main(String[] args){
        Dom4jModify();
    }

    private static void Dom4jModify() {
        /*
         *  dom4j进行修改操作
         * */
        //得到document
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //获取根节点
        Element rootElement = document.getRootElement();
        //获取p1的节点
        List<Element> list = rootElement.elements("p1");
        //获取指定的p1节点
        Element p1 = list.get(0);
        //获取p1下面的name标签节点
        Element name1 = p1.element("name");
        //对name标签中的内容进行修改
        name1.setText("魏国平");

        //回写操作
        XMLWriter xmlWriter = Dom4jUtils.xmlWriters(Dom4jUtils.PATH, document);
    }
}
