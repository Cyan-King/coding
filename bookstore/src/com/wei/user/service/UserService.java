package com.wei.user.service;

import com.wei.user.dao.UserDao;
import com.wei.user.domain.User;

public class UserService {

    UserDao userDao = new UserDao();

    public void regist(User form) throws UserException {

        User user = userDao.findByUsername(form.getUsername());
        if (user != null){
            throw new UserException("用户已经注册");
        }

        user = userDao.findByEmail(form.getEmail());
        if (user != null){
            throw new UserException("邮箱已经注册");
        }

        userDao.add(form);
    }


    /**
     * 激活功能
     * @param code
     * @throws UserException
     */
    public void activ(String code) throws UserException {
        /**
         * 使用code查询数据库，得到user
         */
        User user = userDao.findByCode(code);

        //查询是句酷code激活码是否为空，若为空的话就抛出异常
        if (user == null) throw new UserException("没有激活码！");

        //校验用户状态是否未激活，如果激活（true）的就抛出异常，说明二次激活
        if (user.isState()) throw new UserException("已经激活了，别激活了！");

        userDao.updateState(user.getUid(), true);
    }


    /**
     * 登录功能
     * @param form
     * @return
     */
    public User login(User form) throws UserException {

        /**
         * 使用数据库查询uesername得到user对象
         * 判断username是否为空，为空抛出异常
         * 使用user对象判定form的password是否相同，如果不同的话我们就抛出异常
         * 查看用户状态，如果是flase的话抛出异常
         * 返回user对象
         */
        User user = userDao.findByUsername(form.getUsername());

        //判断username是否为为空
        if (user == null) throw new UserException("用户不存在");

        //判断form的密码和user的密码是否相同
        if (!user.getPassword().equals(form.getPassword())) throw new UserException("密码输入错误");

        //判断状态是否激活
        if (!user.isState()) throw new UserException("账户未激活！");

        return user;

    }
}
