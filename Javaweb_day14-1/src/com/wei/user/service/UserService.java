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

        /**
         * 返回查询到的name信息是否存在
         */
        User _user = userDao.findByUsername(user.getUsername());

        //如果返回的信息不是空的话我们返回这个错误信息
        if (_user != null){
            throw new UserException("用户名" + user.getUsername() + "已经注册");
        }

        userDao.add(user);

    }

    /**
     *
     * @param form
     * @return
     * @throws UserException
     */
    public User login(User form) throws UserException {

        /**
         * 查询name是否存在如果不存在的话返回null
         * 如果找不到的话就是null，使用UserException抛出异常信息
         * 如果查询到了user我们继续判断密码是否相同，如果密码相同的话我们使用UserException抛出异常信息
         * 用户名和密码都正确的话我们返回给user对象
         */


        /**
         * 返回查询到的name信息是否存在
         */
        User user = userDao.findByUsername(form.getUsername());

        //如果查询不到返回错误信息
        if (user == null){
            throw new UserException("用户名不存在");
        }

        //如果查询到了但是密码错误，返回这个错误信息
        if (!user.getPassword().equals(form.getPassword())){
            throw new UserException("密码错误");
        }

        /**
         * 返回的是user而不是form，因为user是所有的数据信息，而form是表单信息
         */
        return user;
    }
}
