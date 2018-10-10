package com.wei.web.servlet;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProvinceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码问题
        response.setContentType("text/html;charset=utf-8");
        //响应所有省份名称。使用逗号分隔开来

        try {
            //先得到document得到路径china.xml
            SAXReader reader = new SAXReader();
            //找到china.xml文件的路径
            InputStream input = this.getClass().getResourceAsStream("/china.xml");
            Document document = reader.read(input);

            //查询数据，查询这个xml文件中的province元素的name属性的值
            List<Attribute> listatt =  document.selectNodes("//province/@name");
            //使用StringBuilder来装这个写数据
            StringBuilder sb = new StringBuilder();

            //便利查询到的数据
            for (int i = 0; i < listatt.size(); i++){
                //将每个属性的name值都存放到sb中
                sb.append(listatt.get(i).getValue());

                if (i < listatt.size() -1){
                    sb.append(",");
                }

            }
            //将sb响应到客户端
            response.getWriter().print(sb);

        }catch (Exception e){
            throw new RuntimeException(e);
        }



    }
}
