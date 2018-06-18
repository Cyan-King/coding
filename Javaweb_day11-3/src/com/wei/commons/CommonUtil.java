package com.wei.commons;

import java.util.UUID;

public class CommonUtil {

    public static String uuid(){

        //我们使用UUID这个类来获得一个36位的16位字符串张来描述一个session---id
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }
}
