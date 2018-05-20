package com.wei.servlet.include;

/*
* 演示请求包含-----请求包含留头又留体
* */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IncludeOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("IncludeOneServlet");
        //设置请求头
        response.setHeader("a", "AA");
        response.setContentType("text/html;charset=utf-8");

        //设置A的请求体
        response.getWriter().print("<h1>" +"魏国"+"</h1>");

        request.getRequestDispatcher("/IncludeTwoServlet").include(request, response);

    }
}
