package com.wei.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/AServlet")
@MultipartConfig
public class AServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");

        //得到Part对象
        Part part = request.getPart("upload");

        System.out.println(username);

        //得到文件的文件类型
        System.out.println(part.getContentType());
        //得到表单项名称
        System.out.println(part.getName());
        //得到指定头中的值
        System.out.println(part.getHeader("Content-Disposition"));
        //获取上传文件的大小
        System.out.println(part.getSize());
        //将上传文件保存到指定位置
        part.write("F:/CodeIOImage/Javaweb_day28-3/The Girl.jpg");

        //截取文件名称
        String filename = part.getHeader("Content-Disposition");
        int start = filename.lastIndexOf("filename=\"")+ 10;
        int end = filename.length() -1;
        System.out.println(start);
        System.out.println(end);
        filename = filename.substring(start, end);

        System.out.println(filename);

    }
}
