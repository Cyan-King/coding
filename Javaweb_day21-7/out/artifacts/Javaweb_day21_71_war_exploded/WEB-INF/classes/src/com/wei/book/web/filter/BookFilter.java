package com.wei.book.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebFilter(filterName = "BookFilter")
public class BookFilter implements Filter {

    private FilterConfig filterConfig;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        /**
         * 首先我们得到文件名和文件路径
         */
        String vaulue = req.getParameter("category");
        String htmlPage = vaulue + ".html";//对应的文件名称
        String htmlPath = request.getSession().getServletContext().getRealPath("/htmls");//对应的文件存放路径

        // add by chengpx
        File file = new File(htmlPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        // add by chengpx

        File destFile = new File(htmlPath, htmlPage);

        /**
         * 如果存在的话我们就重定向
         */
        if (destFile.exists()){
            response.sendRedirect(request.getContextPath() + "/htmls/" + htmlPage);
            return;
        }

        /**
         * 如果存在的话我们就要生成这个文件，所以我们要用到response的方法PrintWrite,不过我们要修改将这文件连接到html文件上来
         */

        /**
         * 要绝对路径的原因是我们需要这个路径，而不是File的文件对象
         */
        StaticResponse sr = new StaticResponse(response, destFile.getAbsolutePath());

        chain.doFilter(request, sr);

        response.sendRedirect(request.getContextPath() + "/htmls/" + htmlPage);
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;

    }

}
