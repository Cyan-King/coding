package com.wei.mail;

import com.sun.mail.util.MailSSLSocketFactory;
import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class Demo1 {





//    idpjyqbnoggzbaab
    @Test
    public void test1() {
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.qq.com");// 主机
        props.setProperty("mail.smtp.auth", "true");// 安全认证
        props.setProperty("mail.smtp.from", "1171865284@qq.com");// 发件邮箱
        props.setProperty("mail.transport.protocol", "smtp");// 协议


        // ********** 将端口写死 ******************
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
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
            msg.setSubject("JavaMail");
            msg.setText("你还好吗？");
            transport = session.getTransport();
            transport.connect("1171865284@qq.com", "fzcebjvskpgqfibg");// 发件邮箱账号, 授权密码----这里
//            transport.sendMessage(msg, InternetAddress.parse("weiguoping89@gmail.com"));// 收件地址
//            transport.sendMessage(msg, InternetAddress.parse("2743393071@qq.com"));
            transport.sendMessage(msg, new Address[]{new InternetAddress("2743393071@qq.com")});
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
