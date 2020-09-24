package com.xh.mapper;

import com.xh.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();
    void addUser(User user);
}
