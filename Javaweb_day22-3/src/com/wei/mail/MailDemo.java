package com.wei.mail;

import cn.itcast.mail.AttachBean;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class MailDemo {

    @Test
    public void fun() throws MessagingException {

        //第一步得到Session
        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.qq.com");
        props.setProperty("mail.smtp.auth", "true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1171865284", "foyqkrranilgifbd");
            }
        };

        Session session = Session.getInstance(props, auth);
        session.setDebug(true);

        //第二部使用MimeMessage得到邮箱对象
        MimeMessage msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress("1171865284@qq.com"));//发件人
        msg.setRecipients(Message.RecipientType.TO, "weiguoping89@163.com");//收件人

        //邮件的主题
        msg.setSubject("JavaMail---Test邮件");
        //邮件正文
        msg.setContent("这只是一封邮件", "text/html;charset=utf-8");

        //发
        Transport.send(msg);

    }

    /**
     * 在这里我们要获取163的授权密码
     * 附件
     * @throws Exception
     */
    @Test
    public void fun1() throws Exception{
        //第一步得到Session
        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.smtp.auth", "true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("weiguoping89", "Wgp970115");
            }
        };

        Session session = Session.getInstance(props, auth);
        //这里的话我们就可以看到发送的详细过程
        session.setDebug(true);

        //第二部使用MimeMessage得到邮箱对象
        MimeMessage msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress("weiguoping89@163.com"));//发件人
        msg.setRecipients(Message.RecipientType.TO, "1171865284@qq.com");//收件人

        //邮件的主题
        msg.setSubject("Javamail---Test邮件 附件");
//        msg.setContent("test", "text/html;charset=utf-8");

        //////////////////////////////////////

/**
 * 我们有一个主体的话我们我们就可以使用这个主体创建很多很多的部件
 */
        //主体部件
        MimeMultipart list = new MimeMultipart();

        //部件
        MimeBodyPart part1 = new MimeBodyPart();
        //邮件的正文
        part1.setContent("这还是一封邮件", "text/html;charset=utf-8");
        list.addBodyPart(part1);

        MimeBodyPart part2 = new MimeBodyPart();
        part2.attachFile(new File("C:/Users/Cyan-King/Pictures/Saved Pictures/Wallpapers/15853.jpg"));
        part2.setFileName(MimeUtility.encodeText("女孩子2.jpg"));
        list.addBodyPart(part2);

        msg.setContent(list);

        //////////////////////////////////////

        //发
        Transport.send(msg);
    }


    @Test
    public void fun3() throws IOException, MessagingException {

        Session session = MailUtils.createSession("smtp.163.com", "weiguoping89", "Wgp970115");

        Mail mail = new Mail("weiguoping89@163.com", "1171865284@qq.com", "这个是垃圾邮件的垃圾主题", "这个是垃圾邮件的来及正文");

        AttachBean ab1 = new AttachBean(new File("C:/Users/Cyan-King/Pictures/Saved Pictures/Wallpapers/15853.jpg"), "大美女.jpg");
        AttachBean ab2 = new AttachBean(new File("C:/Users/Cyan-King/Pictures/Saved Pictures/Wallpapers/01.jpg"), "小美女.jpg");

        mail.addAttach(ab1);
        mail.addAttach(ab2);

        MailUtils.send(session, mail);

    }

}
