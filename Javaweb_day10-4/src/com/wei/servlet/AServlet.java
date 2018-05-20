package com.wei.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //服务器设置为UTF-8
        request.setCharacterEncoding("utf-8");
        //浏览器设置为UTF-8
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        String username = request.getParameter("username");
        System.out.println(username);
        response.getWriter().println(username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //浏览器设置为UTF-8
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        String username = request.getParameter("username");
        System.out.println(username);
        response.getWriter().println(username);

    }
}
