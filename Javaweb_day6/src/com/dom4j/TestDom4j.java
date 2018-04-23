package com.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class TestDom4j {
    
    public static void main(String[] args) throws DocumentException {
     
//        seletAll();
//        seleSin();
        seleSin2();
    }

    private static void seleSin2() throws DocumentException {
        //创建解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("src/person.xml");
        //得到根节点
        Element rootElement = document.getRootElement();
        //的到p1的节点，我们使用了elements()方法
        List<Element> list = rootElement.elements("p1");
        Element element = list.get(1);
        //得到p1的age标签
        Element age = element.element("age");
        String text = age.getText();
        System.out.println(text);
    }

    //获取单个的标签值
    private static void seleSin() throws DocumentException {

        //创建解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("src/person.xml");
        //获取得到根节点
        Element rootElement = document.getRootElement();
        //得到p1的节点
        Element p1 = rootElement.element("p1");
        //
        //得到name下面的name值
        Element name = p1.element("name");
        String text = name.getText();
        System.out.println(text);
    }

    //获取标签中所有的name值
    private static void seletAll() throws DocumentException {

        //创建解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("src/person.xml");
        //得到根节点
        Element rootElement = document.getRootElement();
        //得到p1节点，但是这是获取所有的p1节点用到了elements()
        List<Element> list = rootElement.elements("p1");
        //得到p1下面的name
        for (Element element: list) {
            Element name = element.element("name");
            String text = name.getText();
            System.out.println(text);

        }
    }
}
