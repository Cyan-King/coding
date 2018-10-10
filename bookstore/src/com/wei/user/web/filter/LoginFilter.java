package com.wei.user.web.filter;

import com.wei.user.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /**
         * 从session中获取用户信息
         * 判断session中是否有用户信息，有的话放行
         * 没有的话抛出异常
         */

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        User user = (User) request.getSession().getAttribute("session_user");
        if (user != null){
            chain.doFilter(req, resp);
        } else {
            request.setAttribute("msg", "您还没有登录呢！");
            request.getRequestDispatcher("jsps/user/login.jsp").forward(request, response);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
