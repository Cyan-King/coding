package com.wei.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class GServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        * 演示字节数据
        * */
        //把一张图片放到字节数组中读取----字节数据是万能的
        String path = "G:/CodeIOImage/Javaweb-day10/15853.jpg";

        FileInputStream fis = new FileInputStream(path);

        byte[] bytes = IOUtils.toByteArray(fis);

        response.getOutputStream().write(bytes);

    }
}
