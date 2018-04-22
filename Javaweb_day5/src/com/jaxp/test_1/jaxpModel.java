package com.jaxp.test_1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

/*
    程序功能：jaxp节点的修改
    姓名：魏国平
    日期：2018年4月19日
*/
public class jaxpModel {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        //创建解析工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //使用解析器解析xml文件
        Document document = documentBuilder.parse("src/com/jaxp/bean/person.xml");

        //获得我们要修改的节点name1
        Node name1 = document.getElementsByTagName("name").item(0);

        //修改节点中的内容
        name1.setTextContent("赵飞");

        //回写操作
        //进行回写操作
        TransMethod(document, "src/com/jaxp/bean/person.xml");
        return;
    }

    private static void TransMethod(Document document, String path1) throws TransformerException {
        //进行回写操作
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(path1));
    }
}
