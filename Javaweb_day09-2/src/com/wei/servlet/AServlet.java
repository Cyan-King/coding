package com.wei.servlet;

/*
* 获取servletcontext信息存储起来
* */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletContext对象
        ServletContext application = this.getServletContext();
        //我们使用serAttribute()方法来创一个键值对---还有个说法就是servletContext里面就有一个map集合
        application.setAttribute("name", "Jack");
    }
}
