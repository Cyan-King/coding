package com.company;

import cn.itcast.vcode.utils.VerifyCode;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {

    @Test
    public void Test1() throws IOException {
        //创建随机数
        VerifyCode verifyCode = new VerifyCode();

        //得到随机数
        BufferedImage image = verifyCode.getImage();

        //得到随机数中的字符串
        String text = verifyCode.getText();
        System.out.println(text);
        verifyCode.output(image, new FileOutputStream("G:/CodeIOImage/Javaweb-day08/b.jpg"));


    }
}
