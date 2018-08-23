package com.wei.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


    /**
     * 1. 获取用户名
     * 2. 判断用户名是否有admin
     * 3. 如果有的话就是管理员
     * 4. 如果没有的话就不是管理员
     * 5. 保存到session里面
     * 6. 转发到index.jsp
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");


        //得到用户名
        String username = request.getParameter("username");

        if (username.contains("admin")) {
            //保存得到session
            request.getSession().setAttribute("admin", username);
        } else {
            //保存得到session
            request.getSession().setAttribute("username", username);
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
