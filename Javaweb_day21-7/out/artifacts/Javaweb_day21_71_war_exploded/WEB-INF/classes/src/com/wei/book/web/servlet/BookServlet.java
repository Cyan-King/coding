package com.wei.book.web.servlet;

import com.wei.book.Dao.BookDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

/**
 * 你是在做静态页面, 这个问题我已经解决了, 数据库的操作我注释掉了, 注意看 StaticResponse, BookFilter 文件
 */
public class BookServlet extends BaseServlet {

    BookDao bookDao = new BookDao();

    public String findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // update by chengpx
        // req.setAttribute("BookList", bookDao.findAll());
        // update by chengpx
        return "/show.jsp";
    }

    public String findByCategory(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String value = req.getParameter("category");//之前是打成了categroy
        //        int category = Integer.getInteger(value);
        // update by chengpx
        //        int category = Integer.parseInt(value);//上面多错误是Int类型转换的错误
        //        req.setAttribute("BookList", bookDao.findByCategory(category));
        // update by chengpx
        return "/show.jsp";

        //        String value = req.getParameter("category");
        //        int category = Integer.parseInt(value);
        //        req.setAttribute("BookList", bookDao.findByCategory(category));
        //        return "/show.jsp";
    }
}
