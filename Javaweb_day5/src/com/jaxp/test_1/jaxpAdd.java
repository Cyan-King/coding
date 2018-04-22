package com.jaxp.test_1;

import org.w3c.dom.*;
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
import java.io.IOException;

public class jaxpAdd {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        //创建解析工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //使用解析器解析下xml文件---document
        Document document = documentBuilder.parse("src/com/jaxp/bean/person.xml");
        //获取所有的p1标签
        NodeList oP1Node = document.getElementsByTagName("p1");
        //获取指定的p1标签
        Node oP1Item = oP1Node.item(0);
        //创建我们想要创建的标签属性sex
        Element osexNode = document.createElement("sex");
        //创建文本
        Text Girl = document.createTextNode("妹子");
        //将文本放入到sex标签中
        osexNode.appendChild(Girl);
        //将标签放入到指定p1中0---
        oP1Item.appendChild(osexNode);

//        System.out.println("OK");

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
