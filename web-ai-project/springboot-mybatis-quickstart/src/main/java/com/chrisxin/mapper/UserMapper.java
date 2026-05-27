package com.chrisxin.mapper;

import com.chrisxin.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //应用程序运行时，会自动地为其创建一个实现类对象，并且自动会自动将该实现类对象放入IOC容器中-bean
public interface UserMapper {

    //@Select("select id, username, password, name, age from user")
    public List<User> findAll();

    @Delete("delete from user where id= #{id}")
    public Integer deleteById(Integer id);

    @Insert("insert into user(username, password, name, age) values (#{username},#{password},#{name},#{age})")
    public void insert(User user);

    @Update("update user set username = #{username},password = #{password},name = #{name},age = #{age} where id=#{id}")
    public void update(User user);

    @Select("select * from user where username=#{username} and password=#{password}")
    public User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
