package com.wei.servlet;

/*
* 获取客户端的IP， 获取请求方式， 获取User-Agent
* */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取客户端IP
        String remoteAddr = request.getRemoteAddr();
        System.out.println("IP ： " + remoteAddr);

        //获取请求方式
        System.out.println("请求方式 : " + request.getMethod());

        //获取名为User-Agent的请求头
        String userName = request.getHeader("User-Agent");

        //contains()方法是判断是否包含
        if (userName.toLowerCase().contains("chrome")){
            System.out.println("您的:" + remoteAddr + "使用的Google浏览器");
        }else if (userName.toLowerCase().contains("firefox")){
            System.out.println("您的:" + remoteAddr + "使用的火狐浏览器");
        }else if (userName.toLowerCase().contains("msie")){
            System.out.println("您的:" + remoteAddr + "使用的IE浏览器");
        }

    }
}
