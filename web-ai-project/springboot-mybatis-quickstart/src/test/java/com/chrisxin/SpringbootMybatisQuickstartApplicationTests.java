package com.chrisxin;

import com.chrisxin.entity.User;
import com.chrisxin.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest //springboot单元测试的注解-当前测试类中的方法运行时，会启动springboot项目-IOC容器也创建成功，可以使用注入
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void testDeleteById(){
        Integer i=userMapper.deleteById(5);
        System.out.println(i);
    }

    @Test
    public void testInsert(){
        userMapper.insert(new User(null,"gaoyuanyuan","666777","高圆圆",18));
    }

    @Test
    public void testUpdate(){
        userMapper.update(new User(6,"zhouyu","666777","周瑜",20));
    }

    @Test
    public void testFindByUsernameAndPassword(){
        User user =userMapper.findByUsernameAndPassword("daqiao","123456");
        System.out.println(user);
    }
}
