package com.wei.web.servlet.listeren;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class BListener implements ServletContextAttributeListener {

    /**
     * 添加属性
     * @param servletContextAttributeEvent
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(servletContextAttributeEvent.getName() + "=" + servletContextAttributeEvent.getValue());
    }

    /**
     * 移除属性
     * @param servletContextAttributeEvent
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println(servletContextAttributeEvent.getName() + "=" + servletContextAttributeEvent.getValue());
    }

    /**
     * 替换属性
     * @param servletContextAttributeEvent
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

        System.out.println(servletContextAttributeEvent.getName() + "=" + servletContextAttributeEvent.getValue()
                +  "==========" + servletContextAttributeEvent.getServletContext().getAttribute(servletContextAttributeEvent.getName()));
    }
}
