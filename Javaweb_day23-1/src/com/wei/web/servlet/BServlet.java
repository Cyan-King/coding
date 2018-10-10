package com.wei.web.servlet;

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
        String xml = "<students>" + "<student number='001'>" +
                "<name>zhangSan</name>" +
                "<age>18</age>" +
                "<sex>male</sex>" +
                "</student>" +
                "</students>";

        response.setContentType("text/xml;charset-utf-8");
        response.getWriter().print(xml);
    }
}
