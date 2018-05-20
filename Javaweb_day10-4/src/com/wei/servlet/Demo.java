package com.wei.servlet;


import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/*演示编码和解码*/
public class Demo {

    @Test
    public void test(){

        String name = "魏国平";
        //%E9%AD%8F%E5%9B%BD%E5%B9%B3----这个编码格式

        try {
            //我们使用URLEncode.encode(String name, String s);来进行编码
            String encode = URLEncoder.encode(name, "utf-8");
            System.out.println(encode);

            //我们使用URLDecoder.decode();我们使用这个方法来解码
            String decode = URLDecoder.decode(name, "utf-8");
            System.out.println(decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
