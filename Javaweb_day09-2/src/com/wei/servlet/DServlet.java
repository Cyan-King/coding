package com.wei.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Set;

public class DServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取路径---getRealPath()方法这个挺好用的
        String path = this.getServletContext().getRealPath("/index.jsp");
        System.out.println(path);
        
        //在指定路径下创建文件
        InputStream in = this.getServletContext().getResourceAsStream("/index.jsp");

        //获取文件下的目录-----getResourcePaths()使用这个方法
        Set<String> paths = this.getServletContext().getResourcePaths("/WEB-INF");
        System.out.println(paths);

    }
}
