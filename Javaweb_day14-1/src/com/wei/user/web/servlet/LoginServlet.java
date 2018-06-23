package com.wei.user.web.servlet;

import cn.itcast.commons.CommonUtils;
import com.wei.user.domain.User;
import com.wei.user.service.UserException;
import com.wei.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");

        //这里依赖于service
        UserService userService = new UserService();

        //封装表单数据
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);

        try{
            User user = userService.login(form);
            request.getSession().setAttribute("sessionUser", user);

            //重定向
            response.sendRedirect(request.getContextPath() + "/user/welcome.jsp");
        }catch (UserException e) {
            //获取异常信息
            request.setAttribute("msg", e.getMessage());
            //将表单数据保存到request
            request.setAttribute("user", form);//这个时用来回显示
            //进行转发操作
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        }
    }
}
