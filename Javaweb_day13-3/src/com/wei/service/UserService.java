package com.wei.service;

import com.wei.dao.UserDao;
import com.wei.daomain.User;

/**
 * 业务逻辑层Service
 */

public class UserService {

    //service依赖于dao（数据层）
    UserDao userDao = new UserDao();

    /**
     * serice使用UserDao来完成
     * @return
     */
    public User find(){
        return userDao.find();
    }
}
