package com.dom4j;

import org.dom4j.Document;
import org.dom4j.Node;

import java.util.List;

public class TestDom4jXpath {

    public static void main(String[] args){

//        test1();
        test2();
    }

    //获取单个得name属性值
    private static void test2() {
        //使用封装得方法获取document
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //使用selectSingleNode("xpath表达式")
        Node node = document.selectSingleNode("//p1[@id='aaaa']/name");
        String text = node.getText();
        System.out.println(text);
    }

    private static void test1() {
        //获取document
        Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //使用selectNode("xpath表达式")获取所有的标签
        List<Node> list = document.selectNodes("//name");
        //循环得遍历name标签
        for (Node node: list) {
            String text = node.getText();
            System.out.println(text);
        }

    }
}
