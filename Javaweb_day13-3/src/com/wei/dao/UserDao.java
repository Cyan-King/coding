package com.wei.dao;

import com.wei.daomain.User;

/**
 * 三层架构的数据层
 * 在xml中查询这个数据，我们这个是一个假数据
 */
public class UserDao {

    public User find(){
        return new User("张三", "123");
    }
}
