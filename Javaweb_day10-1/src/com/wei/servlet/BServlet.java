package com.wei.servlet;

/*
*
* 演示重定向
* */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 想获取location头
        * 发送302码
        *
        * */

       /* response.setHeader("Location", "/Javaweb_day10-1/CServlet");
        response.setStatus(302);*/

       //使用快捷重定向方法
        response.sendRedirect("http://www.bing.com");

        System.out.println("BServlet");

    }
}
