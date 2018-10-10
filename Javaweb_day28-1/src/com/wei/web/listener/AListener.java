package com.wei.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class AListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("出生！");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("死亡！");
    }
}
