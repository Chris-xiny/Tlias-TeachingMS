package com.chrisxin.service;

import com.chrisxin.entity.User;

import java.util.List;

public interface UserService {
    /*
    * 查询所有用户信息
    * */
    public List<User> findAll();
}
