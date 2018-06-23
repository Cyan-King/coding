package com.wei.user.domain;

import java.util.Objects;

/**
 * 实体类
 */

public class User {
    private String username;
    private String password;
    private String verifyCode;
    private String sex;
    private String love;

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                ", sex='" + sex + '\'' +
                ", love='" + love + '\'' +
                '}';
    }

    public User(String username, String password, String verifyCode, String sex, String love) {
        this.username = username;
        this.password = password;
        this.verifyCode = verifyCode;
        this.sex = sex;
        this.love = love;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }
}
