package com.wei.util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

public class CommonsUtils {

    public static String uuid(){

        return UUID.randomUUID().toString().replace("-", "");
    }

    public static <T> T ToBean(Map map, Class<T> clazz){

        try {
            //创建指定类型JavaBean路径
            T bean = clazz.newInstance();

            //将javabean封装起来
            BeanUtils.populate(bean, map);

            //返回javabean路径
            return bean;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
