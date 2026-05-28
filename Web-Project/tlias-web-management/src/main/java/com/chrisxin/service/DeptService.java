package com.chrisxin.service;

import com.chrisxin.entity.Dept;

import java.util.List;

public interface DeptService {
    /*查询所有的部门数据*/
    List<Dept> findAll();


    void deleteById(Integer id);

    void insert(Dept dept);

    Dept findById(Integer id);

    void update(Dept dept);
}
