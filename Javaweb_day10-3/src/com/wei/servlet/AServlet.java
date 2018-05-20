package com.wei.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] loves = request.getParameterValues("love");

        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(loves));

        //使用getParameterNames()获取请求参数的名称
        Enumeration<String> names = request.getParameterNames();

        //获取所有的名称--name
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }*/

        //使用getParameterMap()获取参数
        Map<String, String[]> map = request.getParameterMap();

        for(String names : map.keySet()){

            //使用get()方法获取值
            String[] values = map.get(names);

            //需要使用toString()方法来转成字符串
            System.out.println(names + "=" + Arrays.toString(values));
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xxx = request.getParameter("xxx");
        String yyy = request.getParameter("yyy");
        System.out.println("GET：" + xxx);
        System.out.println("GET ： " + yyy);


    }
}
