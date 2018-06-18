package com.wei.user.web.servlet;

import cn.itcast.vcode.utils.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建VerifyCode对象
        VerifyCode verifyCode = new VerifyCode();
        //获取随机验证码图片
        BufferedImage image = verifyCode.getImage();
        //获取验证码的文本保存到session域中
        request.getSession().setAttribute("session_vcode", verifyCode.getText());
        //将图片响应到客户端中
        VerifyCode.output(image, response.getOutputStream());
    }
}
