package com.wei.user.dao;

import com.wei.user.domain.User;

public interface UserDao {

    public User findByUsername(String username);

    public void add(User user);
}
