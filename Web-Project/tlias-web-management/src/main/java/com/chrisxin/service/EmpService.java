package com.chrisxin.service;

import com.chrisxin.entity.Emp;
import com.chrisxin.entity.EmpQueryParam;
import com.chrisxin.entity.PageResult;

public interface EmpService {
    /**
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);


    /**
     * 添加员工
     */
    void add(Emp emp);
}
