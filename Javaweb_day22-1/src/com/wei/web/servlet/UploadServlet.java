package com.wei.web.servlet;

import cn.itcast.commons.CommonUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        /**
         * 上传的三步
         * 1. 创建工厂
         * 2. 解析器
         * 3. 表单项
         */

        //创建工厂
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

        //使用工厂创建解析器
        ServletFileUpload suf = new ServletFileUpload(diskFileItemFactory);

        try {
            //使用parseRequest()方法解析request中的数据---封装到对象中去了
            List<FileItem> fileItemList = suf.parseRequest(request);

            //这个是第一个表单的
            FileItem f1 = fileItemList.get(0);
            FileItem f2 = fileItemList.get(1);

            System.out.println("普通表单演示：" + f1.getFieldName() + "=" + f1.getString("utf-8"));



            System.out.println("文件表单的演示：");
            System.out.println("Content-Type:" + f2.getContentType());
            System.out.println("size:" + f2.getSize());
            System.out.println("file2:" + f2.getName());

            //保存文件
            String filename = "gril.jpg";
            filename = CommonUtils.uuid() + "_" + filename;
            File destFile = new File("F:/CodeIOImage/Javaweb-day21/" + filename);
            f2.write(destFile);

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
