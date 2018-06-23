package com.wei.user.web.servlet;

import cn.itcast.commons.CommonUtils;
import com.wei.user.domain.User;
import com.wei.user.service.UserException;
import com.wei.user.service.UserService;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //这里依赖于service
        UserService userService = new UserService();

        //封装数据表单到User对象当中---我们以后可以直接使用这个封装数据
        //User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);

        /**
         * 添加表达校验我们使用map集合存储错误信息
         */

        Map<String, String> errors = new HashMap<String, String>();
        String username = form.getUsername();
        String password = form.getPassword();
        String verifyCode = form.getVerifyCode();
        System.out.println(verifyCode);

        //用户名校验
        if (username == null || username.trim().isEmpty()){
            errors.put("username", "用户名不能为空");
        }
        else if (username.length() < 3 || username.length() > 15){
            errors.put("username", "用户名长度应该是3~15之间");
        }

        //密码校验
        if (password == null || password.trim().isEmpty()){
            errors.put("password", "密码不能为空");
        }
        else if (password.length() < 3 || password.length() > 15){
            errors.put("password", "密码长度应该是3~15之间");
        }

        //校验图片
//        String session_vc = (String) request.getSession().getAttribute("session_vcode");

        if (verifyCode == null || verifyCode.trim().isEmpty()){
            errors.put("verifyCode", "验证码不能为空");
        }else if (verifyCode.length() != 4){
            errors.put("verifyCode", "验证码只能是四位数");
        }else if (!verifyCode.equalsIgnoreCase((String) request.getSession().getAttribute("session_vcode"))){
            errors.put("verifyCode", "验证码输入错误");
        }

        //判断是否有错，如果errors不为空的话
        if (errors != null && errors.size() > 0){
            request.setAttribute("errors", errors);
            request.setAttribute("user", form);
            request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
            return;
        }

        /**
         * 添加新功能
         * 1. 进行校验验证码
         *      2. 如果错误,保存表单数据，并且显示错误信息
         *      3.如果正确向下执行
         */
        //首先我们先要获取验证码的文本session
        /*String session_vc = (String) request.getSession().getAttribute("session_vcode");
        //进行校验
        if (!session_vc.equalsIgnoreCase(form.getVerifyCode())){
            request.setAttribute("msg", "验证码错误");
            //保存表单数据
            request.setAttribute("user", form);
            request.getRequestDispatcher("/user/regist.jsp").forward(request,response);
            System.out.println("没有校验---没有校验------------");
            System.out.println("表单输入框验证码：" + form.getVerifyCode());
            System.out.println("表单输入框用户名：" + form.getUsername());
            System.out.println("表单输入框密  码：" + form.getPassword());
            System.out.println(request.getSession().getAttribute("session_vcode"));
            return;
        }*/

        try {
            //这个就是登陆成功
            userService.regist(form);
            request.getSession().setAttribute("sessionUser2", form);

            response.getWriter().print("<h1>登录成功</h1><a href='" + request.getContextPath() + "/user/login.jsp" + "'>点击这里登录</a><br/>");
        } catch (UserException e) {
            //获取异常信息
            request.setAttribute("msg", e.getMessage());
            //将表单数据保存到request
            request.setAttribute("user", form);//这个时用来回显示
            //进行转发操作
            request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
