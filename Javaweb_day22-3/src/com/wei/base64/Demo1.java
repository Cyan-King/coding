package com.wei.base64;

import org.junit.Test;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Demo1 {

    @Test
    public void fun1(){
        String s = "UserName";
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            //base64编码
            s = encoder.encode(s.getBytes("utf-8"));
            System.out.println(s);

            //base64解码
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(s);
            System.out.println(new String(bytes, "utf-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
