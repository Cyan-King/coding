package com.wei.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BServlet")
public class BServlet extends BaseServlet {
    public String fun1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fun1");
        return "/index.jsp";
    }

    public String fun2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fun2");
        return "r:/index.jsp";
    }

    public String fun3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fun3");
        return "f:/index.jsp";
    }

    public String fun4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fun4");
        return "d:/index.jsp";
    }


}
