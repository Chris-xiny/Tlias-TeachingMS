package com.chrisxin.service.impl;

import com.chrisxin.entity.Emp;
import com.chrisxin.entity.EmpExpr;
import com.chrisxin.entity.EmpQueryParam;
import com.chrisxin.entity.PageResult;
import com.chrisxin.mapper.EmpExprMapper;
import com.chrisxin.mapper.EmpMapper;
import com.chrisxin.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    /*原始分页查询
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        Long total = empMapper.count();
        //计算起始页码
        Integer start = (page - 1) * pageSize;

        List<Emp> rows = empMapper.list(start, pageSize);
        PageResult<Emp> pageResult=new PageResult<>(total,rows);
        return pageResult;
    }*/

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        //设置分页参数
        //PageHelper只会对紧跟着的第一条sql语句进行分页处理
        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());
        //执行查询
        List<Emp> rows=empMapper.list(empQueryParam);
        Page<Emp> p=(Page<Emp>)rows;
        //解析查询结果
        return new PageResult<>(p.getTotal(),p.getResult());
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        //添加员工信息
        empMapper.add(emp);
        //添加员工经理
        List<EmpExpr> exprList=emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            //遍历每一段员工经历为其添加员工id进行绑定
            for (EmpExpr empExpr : exprList) {
                empExpr.setEmpId(emp.getId());
            }
            empExprMapper.addBatch(exprList);
        }
    }
}
