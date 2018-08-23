package com.wei.book.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebFilter(filterName = "BookFilter")
public class BookFilter implements Filter {

    private FilterConfig config;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String category = request.getParameter("category");
        String htmlPage = category + ".html";
        String htmlPath = config.getServletContext().getRealPath("htmls");

        File destFilt = new File(htmlPath, htmlPage);

        if (destFilt.exists()){
            response.sendRedirect(request.getContextPath() + "/htmls/" + htmlPage);
            return;
        }

        StaticResponse sr = new StaticResponse(response, destFilt.getAbsolutePath());


        chain.doFilter(req, sr);

        response.sendRedirect(request.getContextPath() + "/htmls/" + htmlPage);
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;

    }

}
