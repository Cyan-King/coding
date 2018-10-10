package com.wei.category.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.wei.category.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryServlet extends BaseServlet {

    private CategoryService categoryService = new CategoryService();


    /**
     * 查询所有分类
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("CategoryList", categoryService.findAll());

        return "f:/jsps/left.jsp";
    }
}
