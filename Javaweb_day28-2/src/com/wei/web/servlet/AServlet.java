package com.wei.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AServlet", asyncSupported = true)
public class AServlet extends HttpServlet {

    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        //得到异步上下文对象
        AsyncContext as = request.startAsync();

        //使用上下文对象，启动任务
        as.start(new Runnable() {
            @Override
            public void run() {
                println("马上开始了！<br/>", response);
                sleep(2000);
                for (char c='A'; c <= 'Z'; c++){
                    println(c+"", response);
                    sleep(250);
                }
                as.complete();
            }

        });

    }

    /**
     * 封装的输出方法
     * @param text
     * @param response
     */
    public void println(String text, HttpServletResponse response){
        try {
            response.getWriter().print(text);
            response.getWriter().flush();
        } catch (IOException e) {
        }
    }

    public void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }


}
