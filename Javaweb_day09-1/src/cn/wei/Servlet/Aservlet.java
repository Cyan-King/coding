package cn.wei.Servlet;

/*
* 生命周期：
* init：初始化
* service::每一次服务器的访问都会调用这个方法
* destroy:服务器关闭时调用-又称之为死亡
* */

import javax.servlet.*;
import java.io.IOException;

public class Aservlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //服务器初始化开始，也就是我们开启这个生命周期我们就会调用这个方法----init(ServletConfig servletConfig)而这个方法一生我们只是调用一次
        System.out.println("inti()..........");
    }

    @Override
    public ServletConfig getServletConfig() {
        //获取Servlet的配置信息
        System.out.println("getServletConfig().......");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //每次服务其相应我们都会调用这个方法service(ServletRequest servletRequest, ServletRespinse servletResponse)
        System.out.println("service()......");
    }

    @Override
    public String getServletInfo() {
        //获取Servlet的信息
        System.out.println("getServletInfo()...............");
        return null;
    }

    @Override
    public void destroy() {
        //服务器关闭的时候我们就可以调用这个方法
        System.out.println("destroy()...............");

    }
}
