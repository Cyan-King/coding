package com.wei.book.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.wei.book.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookService();

    /**
     * 查询所有图书
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("bookList", bookService.findAll());
        return "f:/jsps/book/list.jsp";
    }

    /**
     * 分类查询图书
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cid = request.getParameter("cid");
        request.setAttribute("bookList", bookService.findByCategory(cid));
        return "f:/jsps/book/list.jsp";
    }

    /**
     * 登录
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        request.setAttribute("bookList", bookService.load(bid));
        return "f:/jsps/book/desc.jsp";
    }
}
