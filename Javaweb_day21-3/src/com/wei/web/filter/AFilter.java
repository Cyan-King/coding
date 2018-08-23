package com.wei.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Map;

public class AFilter implements Filter {

    //为了更好的创建Servlet Context
    private FilterConfig filterConfig;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //得到ServletContext中的map
        ServletContext app = filterConfig.getServletContext();
        Map<String, Integer> map = (Map<String, Integer>) app.getAttribute("map");

        //获取客户端的IP
        String IP = req.getRemoteAddr();

        if (map.containsKey(IP)){
            //如果IP不为空的话我们就IP，次数+1
            int cnt = map.get(IP);
            map.put(IP, cnt+1);

        }else {
            //如果IP为空的话，次数为1
            map.put(IP, 1);
        }

        //再次将数据保存再Map集合中
        app.setAttribute("map", map);


        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;

    }

}
