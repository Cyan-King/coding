package com.jaxp.test_1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class jaxpdel {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        //创建解析工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //使用解析器解析xml文件
        Document document = documentBuilder.parse("src/com/jaxp/bean/person.xml");

        //获取我们想要删除的节点
        Node oP1Node = document.getElementsByTagName("p1").item(0);

        //获取要删除节点的父节点我们使用getparentsNode()
        Node parentNode = oP1Node.getParentNode();
        //使用removeChilder()方法删除节点
        parentNode.removeChild(oP1Node);

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

/*


<?xml version="1.0" encoding="utf-8" standalone="no"?>
<perosn>
    <p1>
        <name>赵飞燕</name>
        <age>99</age>
    </p1>
    <p1>
        <name>赵一</name>
        <age>11</age>
    </p1>
</perosn>


* */
