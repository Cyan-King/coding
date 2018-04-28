package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        //得到字符串缓冲区
        BufferedImage bi = new BufferedImage(150, 70, BufferedImage.TYPE_INT_RGB);
        //得他的绘制环境
        Graphics2D gi = (Graphics2D) bi.getGraphics();

        //设置图形形状
        gi.setColor(Color.yellow);
        gi.fillRect(0, 0, 150, 70);


        //设置字体
        gi.setFont(new Font("宋体", 1, 32));
        gi.setColor(Color.black);

        gi.drawString("xml", 15, 15);

        ImageIO.write(bi, "JPEG", new FileOutputStream("G:/CodeIOImage/Javaweb-day08/a.jpg"));
    }
}
