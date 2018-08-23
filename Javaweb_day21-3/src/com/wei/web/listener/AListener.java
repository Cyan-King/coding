package com.wei.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.LinkedHashMap;
import java.util.Map;

@WebListener()
public class AListener implements ServletContextListener {


    /**
     * Map创建在监听器中，随着服务器的开启我们创建Map对象，然后存储再ServletContext
     * 1. 创建Map对象
     * 2. 创建ServletContext对象
     * 3. 将ServletContext对象保存起来
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        ServletContext application = servletContextEvent.getServletContext();
        application.setAttribute("map", map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
