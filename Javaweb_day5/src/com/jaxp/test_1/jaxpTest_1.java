package com.jaxp.test_1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class jaxpTest_1 {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        selectSingle();


    }

    //获取xml中单个的name标签单个的值
    public static void selectSingle() throws ParserConfigurationException, IOException, SAXException {

        /*
        *
        * 1.创建解析器工厂
        * 2.使用解析器工厂创建解析器
        * 3.使用解析器解析xml文件
        * 4.获取区我们要的xml中的元素4
        * */
        // 创建解析器工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //使用解析器解析xml文件
        Document document = documentBuilder.parse("src/com/jaxp/bean/person.xml");
        //src/com/jaxp/bean/person.xml
        //使用document获取标签元素
        NodeList listName = document.getElementsByTagName("name");
        NodeList listAge = document.getElementsByTagName("age");
        Node name1 = listName.item(0);
        Node age2 = listAge.item(1);
        String textName1 = name1.getTextContent();
        String textAge2 = age2.getTextContent();
        System.out.println(textName1);
        System.out.println(textAge2);


    }

    //获取xml中的name标签所有的值
    private static void selectAll() throws ParserConfigurationException, SAXException, IOException {
        /*
         *
         * 1. 创建解析器工厂
         * 2.使用用解析器工厂创建解析器
         * 3.使用解析器解析xml文件
         * */

        //创建解析器工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //使用解析器解析xml文件
        Document document;
        document = documentBuilder.parse("src/com/jaxp/bean/person.xml");
        //获取name标签元素
        NodeList listname = document.getElementsByTagName("name");

        //遍历name标签元素，不过这里我们使用到了getLength()方法获取元素的长度
        for (int i = 0; i < listname.getLength(); i++) {

            Node item = listname.item(i);
            //将标签元素的值打印出来
            String textContent = item.getTextContent();
            System.out.println(textContent);
        }
    }
}
