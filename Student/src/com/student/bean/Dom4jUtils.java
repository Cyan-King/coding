package com.student.bean;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

public class Dom4jUtils {

    public static Document getDocuement(String path) {
        try {
            //创建解析器
            SAXReader saxReader = new SAXReader();
            //获取document
            Document document = saxReader.read(path);
            //返回document
            return  document;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static XMLWriter xmlWriters(String path, Document document){

        OutputFormat format = OutputFormat.createPrettyPrint();
        try {
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path), format);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
