package com.wei.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /**
         * 得到session
         * 然后判断admin是否存在，存在放行，不存在打回到login.jsp
         * 判断useranme是否存在，存在放行，不存在打回到login.jsp
         */
        HttpServletRequest request = (HttpServletRequest) req;
        String name = (String) request.getSession().getAttribute("admin");

        if (name != null) {
            chain.doFilter(req, resp);
            return;
        }

        name = (String) request.getSession().getAttribute("username");

        if (name != null) {
            chain.doFilter(req, resp);
        } else {
            request.setAttribute("msg", "您的权限过低只能在会员页面！");
            request.getRequestDispatcher("/login.jsp").forward(req, resp);
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
