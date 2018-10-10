package com.wei.user.web.serlvet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;
import com.wei.cart.domain.Cart;
import com.wei.user.domain.User;
import com.wei.user.service.UserException;
import com.wei.user.service.UserService;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UserServlet extends BaseServlet {

    UserService userService = new UserService();

    /**
     * 退出功能
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String quite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //删除session
        request.getSession().invalidate();
        return "f:/index.jsp";
    }

    /**
     * 激活功能
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取激活码
        String code = request.getParameter("code");

        //使用激活码来调用activ方法
        try {
            userService.activ(code);

            //激活成功保存正确信息
            request.setAttribute("msg", "激活成功了，别再注册了哈！");
        } catch (UserException e) {
            //激活失败保存错误信息
            request.setAttribute("msg", e.getMessage());
        }

        return "f:/jsps/msg.jsp";
    }

    /**
     * 登录功能
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        try {
            User user = userService.login(form);
            request.getSession().setAttribute("session_user", user);

            if (user.getUsername().equals("admin")){
                return "f:/adminjsps/admin/main.jsp";
            }

            //给用户添加一个购车车
            request.getSession().setAttribute("cart", new Cart());
            return "f:/index.jsp";
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("form", form);
            return "f:/jsps/user/login.jsp";
        }

    }

    /**
     * 注册功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //封装表单数据到User对象下
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        //补全方法
        form.setUid(CommonUtils.uuid());
        form.setCode(CommonUtils.uuid() + CommonUtils.uuid());
        /**
         * 输入校验
         * 在这里我们要创建一个map集合来装载这些错误信息
         * 1. 保存错误信息到request中
         * 2. 保存form到request中（回写操作）
         */
        /*
         * 输入校验
         * 1. 创建一个Map，用来封装错误信息，其中key为表单字段名称，值为错误信息
         */
        Map<String,String> errors = new HashMap<String,String>();
        /*
         * 2. 获取form中的username、password、email进行校验
         */
        String username = form.getUsername();
        if(username == null || username.trim().isEmpty()) {
            errors.put("username", "用户名不能为空！");
        } else if(username.length() < 3 || username.length() > 10) {
            errors.put("username", "用户名长度必须在3~10之间！");
        }

        String password = form.getPassword();
        if(password == null || password.trim().isEmpty()) {
            errors.put("password", "密码不能为空！");
        } else if(password.length() < 3 || password.length() > 10) {
            errors.put("password", "密码长度必须在3~10之间！");
        }

        String email = form.getEmail();
        if(email == null || email.trim().isEmpty()) {
            errors.put("email", "Email不能为空！");
        } else if(!email.matches("\\w+@\\w+\\.\\w+")) {
            errors.put("email", "Email格式错误！");
        }
        /*
         * 3. 判断是否存在错误信息
         */
        if(errors.size() > 0) {
            // 1. 保存错误信息
            // 2. 保存表单数据
            // 3. 转发到regist.jsp
            request.setAttribute("errors", errors);
            request.setAttribute("form", form);
            return "f:/jsps/user/regist.jsp";
        }

        try {
            userService.regist(form);


        } catch (UserException e) {
            /**
             * 保存异常信息到request
             * 保存form信息到request
             * 转发regist.jsp
             */
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("form", form);
            return "f:/jsps/user/regist.jsp";
        }

        /**
         * 发邮件
         * 配置文件
         */
        Properties prop = new Properties();
        prop.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
        String host = prop.getProperty("host");//服务器获取服务器主机
        String uname = prop.getProperty("uname");//用户名
        String pwd = prop.getProperty("pwd");//密码
        String from = prop.getProperty("from");//发件人
        String to = form.getEmail();//收件人
        String subject = prop.getProperty("subject");//主题
        String content = prop.getProperty("content");//内容

        content = MessageFormat.format(content, form.getCode());

        Session session = MailUtils.createSession(host, uname, pwd);
        Mail mail = new Mail(from, to, subject, content);
        try {
            MailUtils.send(session, mail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


        /**
         * 如果运行到了这里的话就证明注册成功了
         * 转发到msg.jsp
         */
        request.setAttribute("msg", "恭喜，注册成功！请马上到邮箱激活");
        return "f:/jsps/msg.jsp";
    }
}
