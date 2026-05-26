package com.chrisxin.controller;

import com.chrisxin.entity.User;
import com.chrisxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController//该注解底层中的注解:@ResponseBody->作用:将Controller的返回值直接作为响应体的数据直接响应；如果返回值是对象或集合，先转json再响应
public class userController {
    /*@RequestMapping("/list")
    public List<user> list() {
        //1.加载并读取user.txt，获取用户数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        //2.解析用户信息，封装为user对象->list集合
        List<user> userlist = lines.stream().map(line -> {
                    String[] parts = line.split(",");
                    Integer i = Integer.parseInt(parts[0]);
                    String username = parts[1];
                    String password = parts[2];
                    String name = parts[3];
                    Integer age = Integer.parseInt(parts[4]);
                    LocalDateTime updatetime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    return new user(i, username, password, name, age, updatetime);
                }
        ).toList();
        //3.返回数据(json)
        //服务端会自动将对象或者集合转为js格式
        return userlist;
    }*/

    //方式一：属性注入
    @Autowired
    private UserService userService;

    //方式二：构造器注入
    //private final UserService userService;
    //
    //@Autowired
    //public userController(UserService userService) {
    //    this.userService = userService;
    //}

    //方式三:setter注入
    //private UserService userService;
    //@Autowired
    //public void setUserService(UserService userService) {
    //      this.userService = userService;
    //}

    @RequestMapping("/list")
    public List<User> list() {
        //3.返回数据(json)
        List<User> users = userService.findAll();
        //服务端会自动将对象或者集合转为js格式
        return users;
    }
}
