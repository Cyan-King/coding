package com.wei.servlet;

/*
* 使用ServletContext读取数据
* */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletcontext对象
        ServletContext application = this.getServletContext();
        //使用getAttribute()方法获取数据
        String name = (String) application.getAttribute("name");
        System.out.println(name);
    }
}
