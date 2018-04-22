package com.jaxp.test_1;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class jaxpList {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        //创建解析工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //使用解析器解析xml文件
        Document document = documentBuilder.parse("src/com/jaxp/bean/person.xml");

        list(document);

    }

    private static void list(Node node) {

        //获取节点标签名称并判段是否是标签名，如果不是标签明的话就不输出了
        if (node.getNodeType() == Node.ELEMENT_NODE){
            System.out.println(node.getNodeName());
        }
        // 得到子节点，这只是第一次
        NodeList list1 = node.getChildNodes();

        for(int i = 0; i < list1.getLength(); i++){

            //得到每一个子节点
            Node item = list1.item(i);

            list(item);
        }
    }

}
