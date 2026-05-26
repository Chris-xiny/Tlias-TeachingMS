package com.chrisxin.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.chrisxin.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/*UserDao实现类*/
@Repository//("userDao")
//@Component //将该类交给IOC管理
public class UserDaoImpl implements UserDao {

    @Override
    public List<String> findAll() {
        //1.加载并读取user.txt，获取用户数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        return IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
    }
}
