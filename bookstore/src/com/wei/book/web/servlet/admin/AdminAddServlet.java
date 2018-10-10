package com.wei.book.web.servlet.admin;

import cn.itcast.commons.CommonUtils;
import com.wei.book.domain.Book;
import com.wei.book.service.BookService;
import com.wei.category.domain.Category;
import com.wei.category.service.CategoryService;
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
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminAddServlet extends HttpServlet {
    BookService bookService =  new BookService();
    CategoryService categoryService = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 上传三步：
         * 1. 创建工厂类
         * 2. 创建解析器
         * 3. 使用解析器解析request域
         */
        //创建工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory(30 * 1024, new File("F:/f/temp"));
        //创建解析器
        ServletFileUpload sub = new ServletFileUpload(factory);
        //设置单个文件的大小为30KB
        sub.setFileSizeMax(1024*1024);
        //使用解析器对象解析request域
        try {
            List<FileItem> fileItemList = sub.parseRequest(request);
            //将fileItemList中的数据封装到Book对象中,使用Map集合封装
            Map<String, String> map = new HashMap<String, String>();

            //把普通表单字段封装到Map对象中
            for (FileItem fileItem: fileItemList) {
                //如果是普通表单字段我们就加载到map中，不是的话我们不装，也就是是图片还没有装进来
                if (fileItem.isFormField()){
                    //表单项的名称做键，表单项的值做值
                    map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
                }
            }
            Book book = CommonUtils.toBean(map, Book.class);
            //为book指定bid
            book.setBid(CommonUtils.uuid());
            //把Map中的cid1封装到Category对象中，再把category对象赋给Book
            Category category = CommonUtils.toBean(map, Category.class);
            book.setCategory(category);


            //保存上传的文件
            //保存的目录
            String savepath = this.getServletContext().getRealPath("/book_img");


            //保存文件名称
            String filename = CommonUtils.uuid() +  "_"  + fileItemList.get(1).getName();

            //叫jpg的文件后缀
            if (!filename.toLowerCase().endsWith("jpg")){
                request.setAttribute("msg", "您上传的不是jpg文件");
                request.setAttribute("categoryList", categoryService.findAll());
                request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
                        .forward(request, response);
                return;
            }

            //目标文件
            File destfile = new File(savepath, filename);
            //保存上传文件到目标文件位置
            fileItemList.get(1).write(destfile);

            //把Book图片的位置设置为图片的位置
            book.setImage("book_img/" + filename);



            //使用bookservice#add方法添加图书
            bookService.add(book);

            //校验图片的尺寸
            Image image = new ImageIcon(destfile.getAbsolutePath()).getImage();
            if (image.getWidth(null) > 200 || image.getHeight(null) > 200){
                destfile.delete();//删除这个文件！
                request.setAttribute("msg", "您上传的图片尺寸超出了200 * 200！");
                request.setAttribute("categoryList", categoryService.findAll());
                request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
                        .forward(request, response);
                return;
            }


            //返回图书列表
            request.getRequestDispatcher("/AdminBookServlet?method=findAll").forward(request, response);

        } catch (Exception e) {
            if(e instanceof FileUploadBase.FileSizeLimitExceededException){
                request.setAttribute("msg", "您上传的文件超出了30KB");
                request.setAttribute("categoryList", categoryService.findAll());
                request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
                        .forward(request, response);
            } else {
                request.setAttribute("msg", e.getMessage());
                request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
                        .forward(request, response);
            }
        }

    }
}
