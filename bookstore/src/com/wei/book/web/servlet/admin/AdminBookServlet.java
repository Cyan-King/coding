package com.wei.book.web.servlet.admin;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.wei.book.domain.Book;
import com.wei.book.service.BookService;
import com.wei.category.domain.Category;
import com.wei.category.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminBookServlet extends BaseServlet {
    BookService bookService = new BookService();
    CategoryService categoryService = new CategoryService();

    /**
     * 添加图书
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String addPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("categoryList", categoryService.findAll());
        return "f:/adminjsps/admin/book/add.jsp";

    }

    /**
     * 查询所有图书
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //保存到request域中
        request.setAttribute("bookList", bookService.findAll());

        return "f:/adminjsps/admin/book/list.jsp";
    }

    /**
     * 加载图书信息
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("book", bookService.load(request.getParameter("bid")));
        request.setAttribute("categoryList", categoryService.findAll());
        return "f:/adminjsps/admin/book/desc.jsp";
    }

    /**
     * 删除图书
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bid = request.getParameter("bid");
        bookService.del(bid);
        return findAll(request, response);
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = CommonUtils.toBean(request.getParameterMap(), Book.class);
        Category category = CommonUtils.toBean(request.getParameterMap(), Category.class);
        book.setCategory(category);
        bookService.edit(book);

        return findAll(request, response);
    }
}
