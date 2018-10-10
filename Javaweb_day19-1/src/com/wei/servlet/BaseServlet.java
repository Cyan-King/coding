package com.wei.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //这个必须使用method这个此
        String methodName = request.getParameter("method");

        if (methodName == null || methodName.trim().isEmpty()){
            throw new RuntimeException("您没有调用这参数，无法调用这个method");
        }

        //得到当前class对象
        Class c = this.getClass();

        //通过反射来调用方法
        Method method = null;

        try {
            method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("您调用的方法：" + methodName + "不存在");
        }

        try {
            String result = (String) method.invoke(this, request, response);

            /**
             * 获取请求处理方法执行后返回的字符串也就是result,他表示转发或者重定向路径
             * 这里我们帮他完成转发或者重定向
             */
            //1.我们首先要判断result是否为空或者是""，如果是这样的话我们什么都不做
            if (result == null || result.trim().isEmpty()){
                return;
            }

            //判断result字符串中是否包含:,如果包含我们在进行判断，不包含的话我们直接转发
            if (result.contains(":")){
                //在这里我们就要判断:的位置
                int index = result.indexOf(":");//得到位置
                String start = result.substring(0, index);//截取出冒号之前的位置
                String path = result.substring(index+1);//截取出冒号之后的位置
                if (start.equalsIgnoreCase("f")){
                    request.getRequestDispatcher(path).forward(request, response);//转发
                } else if (start.equalsIgnoreCase("r")){
                    //这个是重定向先要使用request得到项目名，然后使用路径
                    response.sendRedirect(request.getContextPath() + path);
                }else {
                    throw new RuntimeException("您使用的" + result + "现在版本还是不支持的，请重新输入");
                }

            }else {
                //这个要就完成了转发
                request.getRequestDispatcher(result).forward(request, response);
            }


        } catch (Exception e) {
            System.out.println("您调用的方法：" + methodName + "内部抛出异常");
            throw new RuntimeException(e);
        }


    }
}
