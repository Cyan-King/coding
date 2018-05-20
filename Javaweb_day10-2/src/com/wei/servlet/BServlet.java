package com.wei.servlet;

/*
* 使用Referer请求头来演示防盗链效果
*
* */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //我们先要获取这个请求头Referer，使用 getHeader()方法拿到各种各样的请求头
        String referer = request.getHeader("Referer");
        System.out.println(referer);
        if(referer == null || !referer.contains("localhost")) {
            response.sendRedirect("http://www.baidu.com");
        } else {
            System.out.println("hello!");
            System.out.println(request.getRemoteAddr());
        }
        }
}
