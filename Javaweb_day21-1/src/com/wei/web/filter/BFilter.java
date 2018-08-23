package com.wei.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class BFilter implements Filter {

    /**
     * intit()方法是在服务器启动的时候创建Filter对象的时候调用的
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器出生了!!");
    }

    /**
     * 这个doFilter()方法实在每次过滤器进行过滤的时候调用的
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("BFilter#start");
        //这里就是进行方向操作
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("BFilter#end");
    }

    /**
     * 这个destroy()方法实在服务器关闭之前调用的
     */
    @Override
    public void destroy() {
        System.out.println("过滤器要死了");
    }
}
