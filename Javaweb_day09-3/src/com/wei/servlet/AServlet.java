package com.wei.servlet;

/*
* 统计访问次数
* */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AServlet extends HttpServlet {
    /*
    *
    * 获取访问次数：
    * 1. 先要获取servletcontext对象
    * 2. 从servletContext对象中获取count
    * 3. 如果有count的话我们+1
    * 4. 如果没有count的话我们创建count为1
    * */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //创建servletContext对象
        ServletContext app = this.getServletContext();
        //从servletcontext对象中获取count---而我们count对象是一个累加器所以用Integer---添加属性
        Integer count = (Integer) app.getAttribute("count");
        //进行判断count是否有
        if (count == null){
            //如果没有count这个属性的话我们创建这个count然后再次给她一个1
            app.setAttribute("count", 1);
        }else {
            //如果有的话我们count就进行+1操作注意是+1操作不是++操作
            app.setAttribute("count", count+1);
        }


        /*
        *
        * 向浏览器进打印
        * */
        PrintWriter pw  = response.getWriter();

        pw.print("<h1>" + count + "<h1>");

    }
}
