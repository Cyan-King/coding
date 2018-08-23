package com.wei.book.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.wei.book.Dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends BaseServlet {

    BookDao bookDao = new BookDao();

    public String findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setAttribute("BookList", bookDao.findAll());

        return "/show.jsp";
    }

    public String findByCategory(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String value = req.getParameter("category");//之前是打成了categroy
//        int category = Integer.getInteger(value);
        int category = Integer.parseInt(value);//上面多错误是Int类型转换的错误
        req.setAttribute("BookList", bookDao.findByCategory(category));
        return "/show.jsp";

//        String value = req.getParameter("category");
//        int category = Integer.parseInt(value);
//        req.setAttribute("BookList", bookDao.findByCategory(category));
//        return "/show.jsp";
    }
}
