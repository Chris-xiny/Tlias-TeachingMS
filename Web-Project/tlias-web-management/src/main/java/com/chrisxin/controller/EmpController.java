package com.chrisxin.controller;

import com.chrisxin.entity.Emp;
import com.chrisxin.entity.EmpQueryParam;
import com.chrisxin.entity.PageResult;
import com.chrisxin.entity.Result;
import com.chrisxin.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 分页查询员工信息
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询:{}",empQueryParam);
        PageResult<Emp> pageResult=empService.page(empQueryParam);
        return Result.success(pageResult);
    }


    /**
     * 添加员工信息
     */
    @PostMapping
    public Result add(@RequestBody Emp emp){
        empService.add(emp);
        return Result.success();
    }
}
