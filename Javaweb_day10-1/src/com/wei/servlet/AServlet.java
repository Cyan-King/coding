package com.wei.servlet;

/*
*
* 演示编码---response
* */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //在这里我们使用sendError()方法
        response.sendError(404, "您访问的资源就在这里，但是您没有付费所以无方法获得!!!!");

    }
}
