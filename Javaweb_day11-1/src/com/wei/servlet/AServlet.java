package com.wei.servlet;


/*
*
*  演示jsp和servlet的分工
* */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取参数
        String s1 = request.getParameter("num1");
        String s2 = request.getParameter("num2");

        //将参数转化成为integer
        int x = Integer.parseInt(s1);
        int y = Integer.parseInt(s2);

        //进行运算
        int sum = x + y;

        //将运算结果保存到result
        request.setAttribute("result", sum);

        //转换到request
        request.getRequestDispatcher("/jia/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
