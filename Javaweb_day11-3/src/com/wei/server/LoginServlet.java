package com.wei.server;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setCharacterEncoding("utf-8");

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (!"MP".equalsIgnoreCase(userName)){

            //添加cookie
            Cookie cookie = new Cookie("uname", userName);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);

            /*
             *
             * 1.获取session
             * 2.保存用户信息到session
             * 3. 然后重定向到succ1
             * */
            HttpSession session = request.getSession();//获取session
            session.setAttribute("userName", userName);//保存用户信息
            response.sendRedirect("/Javaweb_day11-3/session2/succ1.jsp");//重定向到succ1.jsp
        }else {

            request.setAttribute("msg","用户名或者密码错误");//保存错误信息到request
            request.getRequestDispatcher("/session2/login.jsp").forward(request, response);//转发

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
