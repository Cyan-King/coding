package com.wei.servlet.forward;

/*
* 演示请求转发----请求转发是留头不留体
* */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("OneServlet");

        //设置请求头
        response.setHeader("aaa", "AAA");

        //在request域中添加属性
        request.setAttribute("userName", "Tom");

        //调用TowServlet的service()方法---这样就可以请求TwoServlet
        request.getRequestDispatcher("/TwoServlet").forward(request, response);

    }
}
