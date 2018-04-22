package com.jaxp.sax1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class TestSAX {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //创建解析器工厂
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse("src/person.xml", new MyDefault());
    }
}

class MyDefault extends DefaultHandler{

    boolean flag = false;
    int index = 1;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //判断标签是否是name标签，如果是的话就是输出过了
        if ("name".equals(qName)){
            flag = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //如果是的话就直接打印name中的文本数据
//        if (flag == true){
        if (flag == true && index == 1){
            System.out.println(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.print(qName);
        //把flag设置成为false就可以结束标签了
        if ("name".equals(qName)) {
                flag =false;
                index++;

        }
    }
}
