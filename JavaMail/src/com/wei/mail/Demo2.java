package com.wei.mail;

import com.sun.mail.util.MailSSLSocketFactory;
import org.junit.jupiter.api.Test;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class Demo2 {

    @Test
    public void test2(){

        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.qq.com");// 主机
        props.setProperty("mail.smtp.auth", "true");// 安全认证
        props.setProperty("mail.smtp.from", "2819573709@qq.com");// 发件邮箱
        props.setProperty("mail.transport.protocol", "smtp");// 协议
        // ****************** 开启 SSL 加密 ******************// 适用于 QQ 邮件服务器
        MailSSLSocketFactory sf;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        // ****************** 开启 SSL 加密 ******************// 适用于 QQ 邮件服务器
        Session session = Session.getInstance(props);
        session.setDebug(true);// 显示调试信息
        Message msg = new MimeMessage(session);
        Transport transport = null;
        try {
            msg.setSubject("hello javamail");
            msg.setText("hello, world");
            transport = session.getTransport();
            transport.connect("2819573709@qq.com", "mcrbxtrmrfptdfei");// 发件邮箱账号, 授权密码
            transport.sendMessage(msg, InternetAddress.parse("weiguoping89@gmail.com"));// 收件地址
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {
            try {
                transport.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
