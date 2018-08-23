package com.wei.web.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filePath = "D:/CloudMusic/岑宁儿 - 追光者.mp3";

        String contentType = this.getServletContext().getMimeType(filePath);//通过文件获取文件类型

        DownUtils downUtils = new DownUtils();
        String framename = downUtils.filenameEncoding("追光者.mp3", request);

//        String framename = new String ("追光者.mp3".getBytes("GBK"), "ISO-8859-1");

        response.setHeader("Content-Type", contentType);

        String contentDisposition = "atatachment;filename=" + framename;

        response.setHeader("Content-Disposition",contentDisposition);

        //一个流
        FileInputStream inputStream = new FileInputStream(filePath);

        ServletOutputStream outputStream = response.getOutputStream();

        IOUtils.copy(inputStream, outputStream);

    }
}
