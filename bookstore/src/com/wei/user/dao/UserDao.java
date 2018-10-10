package com.wei.user.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.wei.user.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {

    QueryRunner qr = new TxQueryRunner();

    /**
     * 查询用户名
     * @param username
     * @return
     */
    public User findByUsername(String username){

        String sql = "select * from tb_user where username=?";
        try {
            return qr.query(sql, new BeanHandler<User>(User.class), username);
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }


    /**
     * 查询邮件
     * @param email
     * @return
     */
    public User findByEmail(String email){

        String sql = "select * from tb_user where email=?";
        try {
            return qr.query(sql, new BeanHandler<User>(User.class), email);
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }


    /**
     * 添加用户
     * @param user
     */
    public void add(User user){
        String sql = "insert into tb_user values(?,?,?,?,?,?)";

        Object[] params = {user.getUid(), user.getUsername(), user.getPassword(), user.getEmail(), user.getCode(), user.isState()};

        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询激活码
     * @param code
     * @return
     */
    public User findByCode(String code){

        String sql = "select * from tb_user where code=?";
        try {
            return qr.query(sql, new BeanHandler<User>(User.class), code);
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    /**
     * 修改状态
     * @param uid
     * @param state
     */
    public void updateState(String uid, boolean state){
        try {
            String sql = "update tb_user set state=? where uid=?";
            qr.update(sql, state, uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
