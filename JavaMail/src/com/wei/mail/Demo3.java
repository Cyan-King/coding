package com.wei.mail;

import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Demo3 {

    @Test
    public void Test() throws MessagingException {

        Properties pro = new Properties();
        pro.setProperty("mail.smtp.auth", "true");
        pro.setProperty("mail.transport.protocol", "smtp");
        Session session = Session.getInstance(pro);
        session.setDebug(true);

        Message mes = new MimeMessage(session);
        mes.setText("你好啊");
        mes.setFrom(new InternetAddress("2743393071@qq.com"));



        Transport transport = session.getTransport();
        transport.connect("stmp.163.com", 25, "weiguoping89", "Wgp970115");
        transport.sendMessage(mes, new Address[]{new InternetAddress("2743393071@qq.com")});
        transport.close();
    }
}
