package com.wei.servlet;

/*
*
* 获取xml文件中的信息---在这里我们使用getInitParmeter()方法获取context里面的属性值也可以说是信息
* */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext app = this.getServletContext();
        String value = app.getInitParameter("context-name");
        System.out.println(value);

    }
}
