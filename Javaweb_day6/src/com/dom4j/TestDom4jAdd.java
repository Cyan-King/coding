package com.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class TestDom4jAdd {

    public static void main(String[] args) throws DocumentException, IOException {

//        addTag();
        addTag2();
    }

    private static void addTag2() throws DocumentException, IOException {
        //创建解析器
//        SAXReader saxReader = new SAXReader();
        //得到document
//        Document document = saxReader.read("src/person.xml");

        Document document = Dom4jUtils.getDocument("src/person.xml");

        //得到根节点
        Element rootElement = document.getRootElement();
        //得到p1节点
        List<Element> list = rootElement.elements("p1");
        //得到指定的p1节点
        Element p1 = list.get(1);
        //得到p1下面的所有标签
        List<Element> elements = p1.elements();
        //创建标签
        Element school = DocumentHelper.createElement("school");
        //创建标签中的文本
        school.setText("江西应用技术职业学院");
        //添加到指定的位置
        elements.add(2, school);

        //xml回写操作
//        Dom4jUtils.xmlWriters("src/person.xml", document);
        Dom4jUtils.xmlWriters(Dom4jUtils.PATH, document);

    }

    private static void addTag() throws DocumentException, IOException {
        //创建解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("src/person.xml");
        //得到根节点
        Element rootElement = document.getRootElement();
        //得到p1节点
        List<Element> list = rootElement.elements("p1");
        //得到指定的p1节点
        Element element = list.get(1);
        //添加节点标签
        Element sex = element.addElement("sex");
        //添加节点中的内容
        sex.setText("男");

        //执行回写操作
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/person.xml"), format);
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
