package com.wei.user.service;

import com.wei.user.dao.UserDao;
import com.wei.user.domain.User;

/**
 * 业务逻辑类---这个依赖于UserDao
 */
public class UserService {
    private UserDao userDao = new UserDao();

    /**
     * 注册功能
     * 1. 使用用户查询，如果为空的话就进行注册
     * 2. 如果不为空的话我们就抛出UserException异常
     * @param user
     * @throws UserException
     */
    public void regist(User user) throws UserException{

        User _user = userDao.findByUsername(user.getUsername());

        if (_user != null){
            throw new UserException("用户名" + user.getUsername() + "已经注册");
        }

        userDao.add(user);

    }
}
