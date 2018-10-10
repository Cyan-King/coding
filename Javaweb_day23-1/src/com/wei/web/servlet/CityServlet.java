package com.wei.web.servlet;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class CityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml;charset=utf-8");

        try {
            //获取document
            SAXReader reader = new SAXReader();
            InputStream input = this.getClass().getResourceAsStream("/china.xml");
            Document document = reader.read(input);

            /**
             * 1. 获取省份名称
             * 2. 加载该省对应的province元素
             * 3. 将元素转换成为字符串
             * 4. 发送到客户端
             */
            //1. 获取省份名称
            String pname = request.getParameter("pname");
            //2. 加载该省对应的province元素
            Element proEle = (Element) document.selectSingleNode("//province[@name='" + pname + "']");


            //将元素转换成为字符串
            String asxml = proEle.asXML();
            //发送到客户端
            response.getWriter().print(asxml);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
