package com.wei.web.servlet;

import com.wei.daomain.User;
import com.wei.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();

        User user = userService.find();

        request.setAttribute("user", user);

        //进行转发操作
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
