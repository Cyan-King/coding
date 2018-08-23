package com.wei.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //post请求编码解决
        req.setCharacterEncoding("utf-8");

        HttpServletRequest request = (HttpServletRequest) req;

        /**
         * GET请求编码问题
         */
       if (request.getMethod().equals("GET")){
           EncodingRequest er = new EncodingRequest(request);
           chain.doFilter(req, resp);
       } else if (request.getMethod().equals("POST")){
           EncodingRequest er = new EncodingRequest(request);
           chain.doFilter(req, resp);
       }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
