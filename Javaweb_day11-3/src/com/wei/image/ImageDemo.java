package com.wei.image;

import cn.itcast.vcode.utils.VerifyCode;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageDemo {

    @Test
    public void Demo1() throws IOException {

        //创建对象
        VerifyCode vs = new VerifyCode();
        //调用verifyCode对象中的缓冲区方法
        BufferedImage image = vs.getImage();
        //使用output方法来获取输出保存
        vs.output(image, new FileOutputStream("G:/CodeIOImage/Javaweb-day11/a.jpg"));

        System.out.println(vs.getText());
    }

    @Test
    public void Demo2() throws IOException {
        //获取图片缓冲区和图片的大小
        BufferedImage bufferedImage = new BufferedImage(70, 35, BufferedImage.TYPE_INT_ARGB);

        //得到一个绘画环境
        Graphics2D graphics = bufferedImage.createGraphics();
        //设置画板的颜色
        graphics.setColor(Color.white);
        //得到一个画板
        graphics.fillRect(0,0,70,35);
        //设置画板内容的颜色
        graphics.setColor(Color.green);
        //设置护板内容
        graphics.drawString("HELLO", 15, 15);

        //保存起来
        ImageIO.write(bufferedImage, "JPEG",new FileOutputStream("G:/CodeIOImage/Javaweb-day11/b.jpg"));
    }
}
