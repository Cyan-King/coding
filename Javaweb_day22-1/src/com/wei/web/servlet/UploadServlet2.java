package com.wei.web.servlet;

import cn.itcast.commons.CommonUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
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

@WebServlet(name = "UploadServlet2")
public class UploadServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //创建工厂
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory(20 * 1024, new File("F:/CodeIOImage/Javaweb-day21/"));
        //创建解析器
        ServletFileUpload suf = new ServletFileUpload(diskFileItemFactory);
//        suf.setFileSizeMax(1024 * 1024);//单个文件
//        suf.setSizeMax(1024 * 1024 * 10);//表单限制

        try {
            List<FileItem> fileItemList =  suf.parseRequest(request);

            FileItem fileItem = fileItemList.get(1);

            //得到文件保存路径
            String root = this.getServletContext().getRealPath("/WEB-INF/files/");

            /**
             * 生成二层目录
             * 1.得到文件名称
             * 2.得到hashcode
             * 3.转发成为16进制
             * 4.获取连隔字符来生成目录
             */

            //获取上传的文件名称
            String filename = fileItem.getName();

            //处理绝对路径问题
            int indexOf = filename.lastIndexOf("\\");
            if (indexOf != -1){
                filename = filename.substring(indexOf + 1);
            }

            //给文件添加前缀名称
            String savename = CommonUtils.uuid() + "_" + filename;

            //1.得到hashcode
            int hashCode = savename.hashCode();

            //转发成为16进制
            String hex = Integer.toHexString(hashCode);

            //获取两个字符来的到文件夹的创建
            File dirFile = new File(root, hex.charAt(0) + "/" + hex.charAt(1));

            //创建目录链
            dirFile.mkdirs();

            //创建目录文件
            File destFile = new File(dirFile, savename);

            //保存文件
            fileItem.write(destFile);

        } catch (FileUploadException e) {
            if (e instanceof FileUploadBase.FileSizeLimitExceededException){
                request.setAttribute("msg", "您上传的文件多余1M");
                request.getRequestDispatcher("/form3.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
