package com.wei.servlet.forward;

/*
* 演示请求转发
* */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TwoServlet");

        Object userName = request.getAttribute("userName");

        //读取uestName属性的参数值
        response.getWriter().println("<h1>"+userName+"</h1>");

        //设置请求体
        response.getWriter().print("<h1>" + "TowServlet" + "</h1>");


    }
}
