package com.chrisxin.service.impl;

import com.chrisxin.dao.UserDao;
import com.chrisxin.dao.impl.UserDaoImpl;
import com.chrisxin.entity.User;
import com.chrisxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


/*
UserService实现类
*/
@Service//("userService")
//@Component
public class UserServiceImpl implements UserService {

    @Autowired //当程序运行时，自动寻找该类型的bean对象并为其赋值
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        List<String> lines=userDao.findAll();
        //2.解析用户信息，封装为user对象->list集合
        List<User> userlist = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer i = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updatetime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(i, username, password, name, age, updatetime);
                }
        ).toList();
        return userlist;
    }
}
