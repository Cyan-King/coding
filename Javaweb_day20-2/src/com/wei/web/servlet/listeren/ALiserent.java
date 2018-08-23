package com.wei.web.servlet.listeren;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 生命周期监听
 */
public class ALiserent implements ServletContextListener {
    /**
     * 服务器启动的时候进行监听
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("生");
    }

    /**
     * 服务器关闭的时候进行监听
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("死");

    }
}
